# Simon Dice

##### 👤 Autor: Ana Valladares González

Este proyecto es una implementación del juego "Simon Dice" utilizando Kotlin y Jetpack Compose para la interfaz de usuario. El objetivo del juego es seguir una secuencia de colores que se muestra al usuario y repetirla correctamente.

## Estructura del Proyecto

### `MainViewModel.kt`
Esta clase es el ViewModel principal del juego. Contiene la lógica del juego y maneja el estado de la aplicación.

- **Variables:**
  - `errorMessage`: Un `StateFlow` que contiene mensajes de error.
  - `colors`: Una lista de colores disponibles en el juego.

- **Funciones:**
  - `startNewGame()`: Reinicia el juego y agrega un color a la secuencia.
  - `addColorToSequence()`: Agrega un color aleatorio a la secuencia y la muestra.
  - `showSequence()`: Muestra la secuencia de colores al usuario.
  - `userInput(color: Color)`: Recibe el color ingresado por el usuario y lo agrega a la secuencia del usuario.
  - `checkUserSequence()`: Compara la secuencia del usuario con la secuencia del juego.
  - `clearErrorMessage()`: Limpia el mensaje de error.

### `IU.kt`
Este archivo contiene las funciones composables que definen la interfaz de usuario del juego.

- **Funciones Composables:**
  - `interfazColores()`: La interfaz principal que muestra el récord y los botones de colores.
  - `Botones()`: Contiene los botones de colores.
  - `BotonVerde()`, `BotonRosa()`, `BotonAzul()`, `BotonNaranja()`: Botones individuales para cada color.

### `MainViewModelFactory.kt`
Esta clase es una fábrica para crear instancias de `MainViewModel`.

- **Funciones:**
  - `create(modelClass: Class<T>): T`: Crea una instancia de `MainViewModel` utilizando un `RecordRepository`.

### `Datos.kt`
Esta clase es una data class en Kotlin que almacena el récord del juego.

- **Propiedades:**
  - `record`: Un entero que representa el récord del juego.
