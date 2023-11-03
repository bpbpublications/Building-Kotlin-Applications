package chapter_08

import kotlinx.coroutines.flow.*

suspend fun main() {
    val numbersFlowable = flow {
        for (i in 1..10) {
            emit(i)
        }
    }

    numbersFlowable.collect {
        println(it)
    }
}
