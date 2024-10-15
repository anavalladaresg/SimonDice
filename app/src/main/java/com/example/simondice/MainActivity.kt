package com.example.simondice

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simondice.ui.theme.PastelBlue
import com.example.simondice.ui.theme.PastelGreen
import com.example.simondice.ui.theme.PastelOrange
import com.example.simondice.ui.theme.PastelPink

// Clase para mantener el récord del jugador
val recordJugador = DataRecord(0)

/**
 * Actividad principal de la aplicación.
 * @author Ana Valladares Gonzalez
 */
class MainActivity : ComponentActivity() {
    /**
     * Llamado cuando la actividad está comenzando.
     * @param savedInstanceState Si la actividad está siendo re-inicializada después de haber sido previamente cerrada, entonces este Bundle contiene los datos que más recientemente proporcionó en onSaveInstanceState(Bundle).
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llamada a la implementación de la superclase
        enableEdgeToEdge() // Habilitar el modo de pantalla completa
        setContent { // Establecer el contenido de la actividad
            interfazColores() // Mostrar la interfaz de colores
        }
    }
}

/**
 * Función composable para mostrar la interfaz de colores.
 * @param modifier Modificador a aplicar al layout.
 */
@Composable
fun interfazColores(modifier: Modifier = Modifier) {
    var texto_colores = remember { mutableStateListOf("") } // Lista mutable de colores
    var record = remember { mutableStateOf(0) } // Record del jugador

    Box(modifier = Modifier.fillMaxSize()) { // Contenedor principal
        Column( // Columna para mostrar los colores
            modifier = Modifier // Modificador
                .fillMaxSize() // Tamaño máximo
                .background(Color.White), // Fondo
            verticalArrangement = Arrangement.Center, // Alineación vertical
            horizontalAlignment = Alignment.CenterHorizontally // Alineación horizontal
        ) {
            Text( // Texto para mostrar el récord del jugador
                text = "Record: ${recordJugador.record}", // Texto
                style = MaterialTheme.typography.bodyLarge, // Estilo
                modifier = Modifier.padding(16.dp) // Modificador
            )
            Text( // Texto para mostrar los colores presionados
                text = texto_colores.joinToString(", "), // Texto
                style = MaterialTheme.typography.bodyLarge, // Estilo
                modifier = Modifier.padding(16.dp) // Modificador
            )
            Botones(texto_colores, record) //
        }
    }
}

/**
 * Función para incrementar el récord del jugador.
 * @param record MutableState que contiene el valor actual del récord.
 */
fun incrementarRecord(record: MutableState<Int>) {
    record.value += 1
    recordJugador.record = record.value
}

/**
 * Función composable para mostrar un botón verde.
 * @param buttonValues Lista mutable que contiene los valores de los botones presionados.
 * @param record MutableState que contiene el valor actual del récord.
 */
@Composable
fun BotonVerde(buttonValues: MutableList<String>, record: MutableState<Int>) {
    Button(
        onClick = {
            buttonValues.add("Verde")
            incrementarRecord(record)
        },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PastelGreen)
    ) {}
}

/**
 * Función composable para mostrar un botón rosa.
 * @param buttonValues Lista mutable que contiene los valores de los botones presionados.
 * @param record MutableState que contiene el valor actual del récord.
 */
@Composable
fun BotonRosa(buttonValues: MutableList<String>, record: MutableState<Int>) {
    Button(
        onClick = {
            buttonValues.add("Rosa")
            incrementarRecord(record)
        },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PastelPink)
    ) {}
}

/**
 * Función composable para mostrar un botón azul.
 * @param buttonValues Lista mutable que contiene los valores de los botones presionados.
 * @param record MutableState que contiene el valor actual del récord.
 */
@Composable
fun BotonAzul(buttonValues: MutableList<String>, record: MutableState<Int>) {
    Button(
        onClick = {
            buttonValues.add("Azul")
            incrementarRecord(record)
        },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PastelBlue)
    ) {}
}

/**
 * Función composable para mostrar un botón naranja.
 * @param buttonValues Lista mutable que contiene los valores de los botones presionados.
 * @param record MutableState que contiene el valor actual del récord.
 */
@Composable
fun BotonNaranja(buttonValues: MutableList<String>, record: MutableState<Int>) {
    Button(
        onClick = {
            buttonValues.add("Naranja")
            incrementarRecord(record)
        },
        modifier = Modifier
            .padding(16.dp)
            .width(125.dp)
            .height(125.dp),
        shape = CutCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = PastelOrange)
    ) {}
}

/**
 * Función composable para mostrar un conjunto de botones.
 * @param buttonValues Lista mutable que contiene los valores de los botones presionados.
 * @param record MutableState que contiene el valor actual del récord.
 */
@Composable
fun Botones(buttonValues: MutableList<String>, record: MutableState<Int>) {
    Column {
        Row {
            BotonVerde(buttonValues, record)
            BotonRosa(buttonValues, record)
        }
        Row {
            BotonAzul(buttonValues, record)
            BotonNaranja(buttonValues, record)
        }
    }
}

/**
 * Función de vista previa para mostrar los botones en la vista previa de la UI.
 */
@Preview
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewBotones() {
    val buttonValues = remember { mutableStateListOf<String>() }
    val record = remember { mutableStateOf(0) }
    Botones(buttonValues, record)
}