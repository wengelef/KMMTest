package com.example.kmmtest

import com.example.Preferences
import com.example.get
import com.example.set
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CommonViewModel(private val preferences: Preferences) {

    private val mutableStateFlow = MutableStateFlow(preferences[KEY, 0])
    val values = mutableStateFlow.asStateFlow()

    fun increaseValue() {
        val value = preferences[KEY, 0] + 1

        preferences[KEY] = value

        mutableStateFlow.update { value }
    }

    companion object {
        private const val KEY = "key"
    }
}
