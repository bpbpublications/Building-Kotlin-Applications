package chapter_09.transforming

import io.reactivex.rxjava3.core.Observable

fun main() {
    val integerStream: Observable<Int> = Observable.fromArray(1,2,3,4,5,6)
    val sum = integerStream.scan { x, y -> x + y }
    sum.forEach(::println)
}
