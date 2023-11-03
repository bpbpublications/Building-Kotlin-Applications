package chapter_09.reducing

import io.reactivex.rxjava3.core.Observable

fun main() {
    val numbers: Observable<Int> = Observable.fromArray(1, 2, 3, 4, 5)
    val min = numbers.blockingStream().min { o1, o2 -> o1.compareTo(o2) }
    val max = numbers.blockingStream().max { o1, o2 -> o1.compareTo(o2) }
    println("Min=${min.get()}, Max=${max.get()}")
}
