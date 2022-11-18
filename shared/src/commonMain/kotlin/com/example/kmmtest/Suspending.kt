package com.example.kmmtest

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

public sealed interface SealedInterfaceResult {
    data class SomeDataClass(val number: Int) : SealedInterfaceResult
    object SomeObject : SealedInterfaceResult
}

public enum class SomeEnum {
    firstValue, secondValue
}

class Suspending(private val someArgument: Int = 0) {
    suspend fun testSuspendFunction(): Int {
        return 5
    }

    inline fun testSuspendFunction2(f: () -> Unit) {
        f()
    }

    fun numbers(): StateFlow<Int> = MutableStateFlow(1)

    suspend fun testReturnsSealedResult(): SealedInterfaceResult {
        return SealedInterfaceResult.SomeDataClass(5)
    }

    suspend fun testReturnsSomeEnum(): SomeEnum {
        return SomeEnum.firstValue
    }
}
