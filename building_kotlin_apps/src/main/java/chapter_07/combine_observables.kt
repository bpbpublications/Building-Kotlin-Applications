package chapter_07

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

fun main() {
    val observable1: Observable<Int> = Observable.range(1, 4)
    val observable2: Observable<String> = Observable.just("A", "B", "C", "D")

    val observer: Observer<Pair<Int, String>> = object : Observer<Pair<Int, String>> {
        override fun onSubscribe(d: Disposable) {
            println("An observer has been subscribed")
        }

        override fun onNext(value: Pair<Int, String>) {
            println("Received value: $value")
        }

        override fun onComplete() {
            println("Observable completed")
        }

        override fun onError(e: Throwable) {
            println("Observable encountered an error: $e")
        }
    }

    Observable.zip(observable1, observable2) { a, b ->
        Pair(a, b)
    }.subscribe(observer)
}
