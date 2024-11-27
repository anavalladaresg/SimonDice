import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simondice.DataRecord
import com.example.simondice.RecordRepository
import com.example.simondice.ui.theme.PastelBlue
import com.example.simondice.ui.theme.PastelGreen
import com.example.simondice.ui.theme.PastelOrange
import com.example.simondice.ui.theme.PastelPink
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainViewModel(private val repository: RecordRepository) : ViewModel() {
    private val _record = MutableStateFlow(DataRecord(0)) // Se inicializa un MutableStateFlow con un DataRecord de 0
    val record: StateFlow<DataRecord> get() = _record // Se expone el MutableStateFlow como StateFlow

    private val _sequence = MutableStateFlow<List<Color>>(emptyList()) // Se inicializa un MutableStateFlow con una lista vacía de colores
    val sequence: StateFlow<List<Color>> get() = _sequence // Se expone el MutableStateFlow como StateFlow

    private val _userSequence = MutableStateFlow<List<Color>>(emptyList()) // Se inicializa un MutableStateFlow con una lista vacía de colores
    val userSequence: StateFlow<List<Color>> get() = _userSequence // Se expone el MutableStateFlow como StateFlow

    private val _currentColor = MutableStateFlow<Color?>(null) // Se inicializa un MutableStateFlow con un color nulo
    val currentColor: StateFlow<Color?> get() = _currentColor // Se expone el MutableStateFlow como StateFlow

    private val _errorMessage = MutableStateFlow<String?>(null) // Se inicializa un MutableStateFlow con un mensaje de error nulo
    val errorMessage: StateFlow<String?> get() = _errorMessage // Se expone el MutableStateFlow como StateFlow


    private val colors = listOf(PastelGreen, PastelPink, PastelBlue, PastelOrange) // Se inicializa una lista de colores

    /**
     * Se inicializa el ViewModel llamando a la función startNewGame
     */
    init {
        startNewGame()
    }

    /**
     * Se crea la función startNewGame, que reinicia la secuencia y el record, y agrega un color a la secuencia
     */
    fun startNewGame() {
        _sequence.value = emptyList() // Se reinicia la secuencia
        _userSequence.value = emptyList() // Se reinicia la secuencia del usuario
        addColorToSequence() // Se agrega un color a la secuencia
    }

    /**
     * Se crea la función addColorToSequence, que agrega un color aleatorio a la secuencia y muestra la secuencia
     */
    fun addColorToSequence() {
        val newColor = colors[Random.nextInt(colors.size)] // Se obtiene un color aleatorio de la lista de colores
        _sequence.value = _sequence.value + newColor // Se agrega el color a la secuencia
        showSequence() // Se muestra la secuencia
    }

    /**
     * Se crea la función showSequence, que muestra la secuencia de colores
     */
    fun showSequence() {
        // Se itera sobre la secuencia y se muestra cada color
        viewModelScope.launch {
            _sequence.value.forEach { color ->
                _currentColor.value = color
                delay(1000)
                _currentColor.value = null
                delay(500)
            }
        }
    }

    /**
     * Se crea la función userInput, que recibe un color y lo agrega a la secuencia del usuario
     */
    fun userInput(color: Color) {
        _userSequence.value += color // Add the color to the user's sequence
        Log.d("MainViewModel", "User input color: $color") // Log the color input
        // If the user's sequence has the same size as the game's sequence, call the checkUserSequence function
        if (_userSequence.value.size == _sequence.value.size) {
            checkUserSequence()
        }
    }

    /**
     * Se crea la función checkUserSequence, que compara la secuencia del usuario con la secuencia del juego
     */
    fun checkUserSequence() {
        if (_userSequence.value == _sequence.value) {
            _record.value = DataRecord(_record.value.record + 1)
            _userSequence.value = emptyList()
            addColorToSequence()
        } else {
            Log.e("MainViewModel", "User sequence does not match the game sequence")
            _errorMessage.value = "¡Has perdido! Inténtalo de nuevo."
            startNewGame()
        }
    }

    fun clearErrorMessage() {
        _errorMessage.value = null
    }
}