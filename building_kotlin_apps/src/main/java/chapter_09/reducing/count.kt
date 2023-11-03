package chapter_09.reducing

import io.reactivex.rxjava3.core.Observable

fun main() {
    val numbers: Observable<Int> = Observable.fromArray(1, 2, 3, 4, 5)
    val count: Long = numbers.count().blockingGet()
    println("Count: $count")
}
