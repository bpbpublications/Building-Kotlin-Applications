package chapter_09.transforming

import io.reactivex.rxjava3.core.Observable

fun main() {
    val integerStreamList: Observable<List<Int>> =
        Observable.fromArray(listOf(1, 2), listOf(3, 4, 5), listOf(6))
    val flat = integerStreamList.flatMap { list -> Observable.fromIterable(list) }
    flat.forEach(::println)
}
