package chapter_08

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.reactive.collect
import kotlinx.coroutines.rx2.asFlowable
import java.util.concurrent.TimeUnit

suspend fun main() {
    val numbersFlowable = flow {
        for (i in 1..10) {
            emit(i)
        }
    }

    numbersFlowable.asFlowable()
        .onBackpressureDrop { println("Dropping item: $it") }
        .buffer(2)
        .map { it.sum() }
        .filter { it % 2 == 0 }
        .collect { println(it) }
}
