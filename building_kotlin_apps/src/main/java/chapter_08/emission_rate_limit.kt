package chapter_08

import io.reactivex.rxjava3.core.Flowable
import kotlinx.coroutines.reactive.collect
import java.util.concurrent.TimeUnit

suspend fun main() {
    Flowable.interval(100, TimeUnit.MILLISECONDS)
        .onBackpressureLatest()
        .map {
            Thread.sleep(1000)
            it
        }
        .buffer(10)
        .collect { println(it) }

}
