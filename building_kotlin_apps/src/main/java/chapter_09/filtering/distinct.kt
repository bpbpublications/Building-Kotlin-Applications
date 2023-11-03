package chapter_09

import io.reactivex.rxjava3.core.Observable

fun main() {
    val stream: Observable<String> = Observable.fromArray("Ali", "John", "Sarah", "Ali", "John", "Mike")
    val distinctNames: Observable<String> = stream.distinct()
    distinctNames.subscribe(::println)
}
