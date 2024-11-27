package com.example.simondice

import MainViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {
    /**
     * Se crea una instancia de MainViewModel utilizando el método viewModels, que recibe un lambda
     * que retorna un MainViewModelFactory. Este recibe un RecordRepository.
     */
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory(RecordRepository())
    }

    /**
     * Se crea la actividad y se le asigna el contenido de la interfaz de usuario.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            interfazColores(mainViewModel)
        }
    }
}