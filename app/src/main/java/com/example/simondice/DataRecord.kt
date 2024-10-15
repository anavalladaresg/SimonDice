package com.example.simondice

data class DataRecord(var record: Int) {
    fun saveRecord(record: Int) {
        this.record = record
    }
}