package chapter_09

import io.reactivex.rxjava3.core.Observable

fun main() {
    val stream: Observable<Int> = Observable.fromArray(1,2,3,4,5,6,7,8,9)
    val greaterThanFour: Observable<Int> = stream.skipWhile { x -> x <= 4 }
    greaterThanFour.subscribe(::println)
}
