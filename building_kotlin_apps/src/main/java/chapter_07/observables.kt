package chapter_07

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


fun main() {
    val observable: Observable<Int> = Observable.range(1, 10)
    val observer: Observer<Int> = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            // This method is called when the Observer subscribes to the Observable
            println("An observer has been subscribed")
        }

        override fun onNext(value: Int) {
            println("Received value: $value")
        }

        override fun onComplete() {
            println("Observable completed")
        }

        override fun onError(e: Throwable) {
            println("Observable encountered an error: $e")
        }
    }

    //1.
//    observable.subscribe(observer)

    //2. Observable with filter and map operators
    observable
        .filter { it % 2 == 0 }
        .map { it * 2 }
        .subscribe(observer)

}
