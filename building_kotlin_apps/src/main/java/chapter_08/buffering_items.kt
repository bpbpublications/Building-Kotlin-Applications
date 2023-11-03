package chapter_08

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.reactive.collect
import kotlinx.coroutines.rx2.asFlowable

suspend fun main() {
    val numbersFlowable = flow {
        for (i in 1..10) {
            emit(i)
        }
    }

    numbersFlowable.asFlowable()
        .buffer(3)
        .onBackpressureBuffer(3)
        .collect { println(it) }

}
