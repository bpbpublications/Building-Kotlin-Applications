package chapter_09

import io.reactivex.rxjava3.core.Observable

fun main() {
    val stream: Observable<Int> = Observable.fromArray(1,2,3,4,5,6)
    val lessOrEqualThree: Observable<Int> = stream.takeWhile { x -> x <= 3 }
    lessOrEqualThree.subscribe(::println)
}
