package com.example

import platform.Foundation.NSUserDefaults

actual class Preferences {

    private val userDefaults = NSUserDefaults.standardUserDefaults()

    public actual fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        userDefaults.boolForKey(key)

    public actual fun putBoolean(key: String, value: Boolean) {
        userDefaults.setBool(value, key)
    }

    public actual fun getInt(key: String, defaultValue: Int): Int =
        userDefaults.integerForKey(key).toInt()

    public actual fun putInt(key: String, value: Int) {
        userDefaults.setInteger(value.toLong(), key)
    }

    public actual fun getLong(key: String, defaultValue: Long): Long =
        userDefaults.integerForKey(key)

    public actual fun putLong(key: String, value: Long) {
        userDefaults.setInteger(value, key)
    }

    public actual fun getString(key: String, defaultValue: String): String =
        userDefaults.stringForKey(key) ?: defaultValue

    public actual fun putString(key: String, value: String) {
        userDefaults.setObject(value, key)
    }
}