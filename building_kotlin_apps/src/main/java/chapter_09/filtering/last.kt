package chapter_09

import io.reactivex.rxjava3.core.Observable

fun main() {
    val stream: Observable<Int> = Observable.fromArray(2, 3, 4, 5, 6, 7, 8)
    val lastOdd: Observable<Int> = stream.filter { x -> x % 2 == 1 }.last(0).toObservable()
    lastOdd.subscribe(::println)
}
