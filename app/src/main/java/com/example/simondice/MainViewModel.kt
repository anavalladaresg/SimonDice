// MainViewModel.kt
package com.example.simondice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repository: RecordRepository) : ViewModel() {
    private val _record = MutableStateFlow(DataRecord(0))
    val record: StateFlow<DataRecord> get() = _record

    init {
        viewModelScope.launch {
            repository.record.collect {
                _record.value = it
            }
        }
    }

    fun incrementarRecord() {
        viewModelScope.launch {
            repository.incrementarRecord()
        }
    }
}