package chapter_09

import io.reactivex.rxjava3.core.Flowable


fun main() {
    val numbers: Flowable<Int> = Flowable.fromIterable(1..10)
        .onBackpressureBuffer()
        .doOnNext { x ->
            if (x == 4) throw Exception("Error: Number 4 is not allowed")
        }

    numbers
        .filter { x -> x % 2 == 0 }
        .groupBy { x -> x > 3 }
        .flatMap { group -> group.map { x -> x * 2 }.onErrorReturn { error -> -1 } }
        .subscribe(
            { x -> println("Result: $x") }
        ) { error -> println("Error: $error") }

}
