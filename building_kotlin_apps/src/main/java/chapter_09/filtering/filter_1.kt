package chapter_09

import io.reactivex.rxjava3.core.Observable

fun main() {
    val stream: Observable<Int> = Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val evenNumbers: Observable<Int> = stream.filter { x -> x % 2 == 0 }
    evenNumbers.subscribe(::println)
}
