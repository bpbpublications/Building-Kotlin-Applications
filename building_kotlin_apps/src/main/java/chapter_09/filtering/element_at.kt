package chapter_09

import io.reactivex.rxjava3.core.Observable

fun main() {
    val stream: Observable<Int> = Observable.fromArray(1, 2, 3, 4, 5)
    val fourthElement: Observable<Int> = stream.elementAt(3).toObservable()
    fourthElement.subscribe(::println)
}
