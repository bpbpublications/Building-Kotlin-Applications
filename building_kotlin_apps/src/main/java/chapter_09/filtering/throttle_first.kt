package chapter_09.filtering

import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit


data class MouseEvent(val x: Int, val y: Int)

fun main() {
    val mouseClicks: Observable<MouseEvent> =
        Observable.fromIterable(mapOf(230 to 100, 350 to 452, 780 to 21)
            .map { MouseEvent(it.key, it.value) })
    val filteredClicks: Observable<MouseEvent> = mouseClicks.throttleFirst(1, TimeUnit.SECONDS)
    filteredClicks.subscribe(::println)
}
