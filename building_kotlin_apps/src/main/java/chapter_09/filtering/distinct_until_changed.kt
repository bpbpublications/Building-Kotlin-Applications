package chapter_09

import io.reactivex.rxjava3.core.Observable

fun main() {
    val stream: Observable<Int> = Observable.fromArray(1, 2, 2, 3, 3, 3, 4, 4, 5, 6, 6)
    val distinctUntilChanged: Observable<Int> = stream.distinctUntilChanged()
    distinctUntilChanged.subscribe(::println)
}
