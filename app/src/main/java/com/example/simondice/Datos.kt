package com.example.simondice

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

data class DataRecord(var record: Int)

class RecordRepository {
    private val _record = MutableStateFlow(DataRecord(0)) // MutableStateFlow es un tipo de flujo que emite un valor y permite modificarlo
    val record: Flow<DataRecord> get() = _record // Se expone el flujo de datos

    /**
     * Incrementa el record
     */
    fun incrementarRecord() {
        _record.value = DataRecord(_record.value.record + 1)
    }
}