package chapter_09.error_handling

import io.reactivex.rxjava3.core.Observable


fun main() {
    val numbers: Observable<Int> =
        Observable.fromArray(1, 2, 3, 4, 5)
            .concatWith(Observable.error(Exception()))
    val safeNumbers: Observable<Int> = numbers.onErrorReturn { -1 }
    safeNumbers.subscribe(::println) { error -> println("Error: $error") }
}
