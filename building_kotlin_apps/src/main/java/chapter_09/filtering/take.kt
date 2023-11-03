package chapter_09

import io.reactivex.rxjava3.core.Observable

fun main() {
    val stream: Observable<Int> = Observable.fromArray(2000,2005,2010,2015,2020)
    val firstThreeYears: Observable<Int> = stream.take(3)
    firstThreeYears.subscribe(::println)
}
