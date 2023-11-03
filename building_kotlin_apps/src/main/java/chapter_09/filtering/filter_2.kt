package chapter_09

import io.reactivex.rxjava3.core.Observable

fun main() {
    val stream: Observable<String> = Observable.fromArray("Kiwi", "Banana", "Lemon", "Orange")
    val containsA: Observable<String> = stream.filter { str -> str.contains("a")}
    containsA.subscribe(::println)
}
