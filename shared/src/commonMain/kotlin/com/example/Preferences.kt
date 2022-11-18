package com.example

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

public expect class Preferences {
    public fun getBoolean(key: String, defaultValue: Boolean): Boolean
    public fun putBoolean(key: String, value: Boolean)

    public fun getInt(key: String, defaultValue: Int): Int
    public fun putInt(key: String, value: Int)

    public fun getLong(key: String, defaultValue: Long): Long
    public fun putLong(key: String, value: Long)

    public fun getString(key: String, defaultValue: String): String
    public fun putString(key: String, value: String)
}

public operator fun Preferences.get(key: String, defaultValue: Boolean): Boolean = getBoolean(key, defaultValue)
public operator fun Preferences.set(key: String, value: Boolean): Unit = putBoolean(key, value)

public operator fun Preferences.get(key: String, defaultValue: Int): Int = getInt(key, defaultValue)
public operator fun Preferences.set(key: String, value: Int): Unit = putInt(key, value)

public operator fun Preferences.get(key: String, defaultValue: Long): Long = getLong(key, defaultValue)
public operator fun Preferences.set(key: String, value: Long): Unit = putLong(key, value)

public operator fun Preferences.get(key: String, defaultValue: String): String = getString(key, defaultValue)
public operator fun Preferences.set(key: String, value: String): Unit = putString(key, value)

public fun Preferences.boolean(key: String, defaultValue: Boolean): ReadWriteProperty<Any, Boolean> =
    BooleanDelegate(this, key, defaultValue)

private class BooleanDelegate(
    private val preferences: Preferences,
    key: String,
    private val defaultValue: Boolean
) : ValueDelegate<Boolean>(key) {
    override fun getValue(key: String): Boolean = preferences[key, defaultValue]
    override fun setValue(key: String, value: Boolean) {
        preferences[key] = value
    }
}

private abstract class ValueDelegate<T>(private val key: String) : ReadWriteProperty<Any, T> {
    abstract fun getValue(key: String): T
    abstract fun setValue(key: String, value: T)

    override fun getValue(thisRef: Any, property: KProperty<*>): T = getValue(key)
    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        setValue(key, value)
    }
}