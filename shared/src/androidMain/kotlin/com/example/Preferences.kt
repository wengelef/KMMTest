package com.example

import android.content.Context
import androidx.core.content.edit

actual class Preferences(context: Context, name: String) {

    private val sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    public actual fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        sharedPreferences.getBoolean(key, defaultValue)

    public actual fun putBoolean(key: String, value: Boolean) {
        sharedPreferences.edit { putBoolean(key, value) }
    }

    public actual fun getInt(key: String, defaultValue: Int): Int =
        sharedPreferences.getInt(key, defaultValue)

    public actual fun putInt(key: String, value: Int) {
        sharedPreferences.edit { putInt(key, value) }
    }

    public actual fun getLong(key: String, defaultValue: Long): Long =
        sharedPreferences.getLong(key, defaultValue)

    public actual fun putLong(key: String, value: Long) {
        sharedPreferences.edit { putLong(key, value) }
    }

    public actual fun getString(key: String, defaultValue: String): String =
        sharedPreferences.getString(key, defaultValue) ?: defaultValue

    public actual fun putString(key: String, value: String) {
        sharedPreferences.edit { putString(key, value) }
    }
}