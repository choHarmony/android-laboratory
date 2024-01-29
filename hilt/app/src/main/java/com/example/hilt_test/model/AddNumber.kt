package com.example.hilt_test.model

import javax.inject.Inject

class AddNumber @Inject constructor() {
    fun addNumber(num: Int): Int {
        return num + 1
    }
}