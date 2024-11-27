package com.example.simondice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(
    private val repository: RecordRepository // Se recibe un RecordRepository como parámetro para poder crear una instancia de MainViewModel
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST") // Se suprime el warning de unchecked cast para poder retornar un MainViewModel

    /**
     * Se sobreescribe el método create, que recibe un modelClass de tipo Class<T> y retorna un ViewModel.
     * Si el modelClass es de tipo MainViewModel, se retorna una instancia de MainViewModel con el RecordRepository
     * que se recibió como parámetro.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) { // Si el modelClass es de tipo MainViewModel
            return MainViewModel(repository) as T // Se retorna una instancia de MainViewModel con el RecordRepository
        }
        throw IllegalArgumentException("Unknown ViewModel class") // Si el modelClass no es de tipo MainViewModel, se lanza una excepción
    }
}
