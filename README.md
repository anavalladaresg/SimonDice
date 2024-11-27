# Simon Dice App

##### 👤 Autor: Ana Valladares González

## Descripción General
La aplicación Simon Dice es un juego desarrollado en Kotlin y Jetpack Compose. La app sigue el patrón de arquitectura MVVM (Model-View-ViewModel) y utiliza corutinas para operaciones asincrónicas. El objetivo principal del juego es repetir la secuencia de colores mostrada por la aplicación.

## Estructura del Proyecto

### MainActivity
- **Propósito**: Punto de entrada principal de la aplicación.
- **Métodos Clave**:
  - `onCreate(savedInstanceState: Bundle?)`: Establece el contenido de la actividad a la interfaz de usuario definida en `interfazColores`.

### MainViewModel
- **Propósito**: Gestiona los datos relacionados con la UI de manera consciente del ciclo de vida.
- **Métodos Clave**:
  - `startNewGame()`: Inicia un nuevo juego.
  - `addColorToSequence()`: Agrega un nuevo color a la secuencia.
  - `showSequence()`: Muestra la secuencia de colores al usuario.
  - `userInput(color: Color)`: Registra la entrada del usuario.
  - `checkUserSequence()`: Verifica si la secuencia del usuario es correcta.

### MainViewModelFactory
- **Propósito**: Clase fábrica para crear instancias de `MainViewModel`.
- **Métodos Clave**:
  - `create(modelClass: Class<T>): T`: Crea y retorna una instancia de `MainViewModel`.

### RecordRepository
- **Propósito**: Gestiona las operaciones de datos y proporciona una API limpia para el acceso a los datos en el resto de la aplicación.
- **Métodos Clave**:
  - `incrementarRecord()`: Incrementa el valor del récord.
- **Propiedades**:
  - `_record`: Un `MutableStateFlow` que contiene el récord actual.
  - `record`: Un `Flow` que expone el récord actual.

### IU.kt
- **Propósito**: Define la interfaz de usuario utilizando Jetpack Compose.
- **Componentes Clave**:
  - `interfazColores(viewModel: MainViewModel, modifier: Modifier)`: El componente principal de la UI que muestra el récord actual y los botones.
  - `Botones(viewModel: MainViewModel, currentColor: Color?)`: Un componente que organiza los botones de colores en una cuadrícula.
  - `BotonVerde(viewModel: MainViewModel, currentColor: Color?)`, `BotonRosa(viewModel: MainViewModel, currentColor: Color?)`, `BotonAzul(viewModel: MainViewModel, currentColor: Color?)`, `BotonNaranja(viewModel: MainViewModel, currentColor: Color?)`: Componentes para cada botón de color que registran la entrada del usuario y se iluminan según la secuencia.

## Finalidad del Proyecto
El propósito de este proyecto es demostrar el uso del patrón de arquitectura MVVM, corutinas para operaciones asincrónicas y Jetpack Compose para construir la interfaz de usuario en una aplicación de juego Simon Dice.