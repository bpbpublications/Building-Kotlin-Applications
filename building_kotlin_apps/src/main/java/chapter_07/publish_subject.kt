package chapter_07

import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import io.reactivex.rxjava3.subjects.PublishSubject

fun main() {
    val subject: PublishSubject<Int> = PublishSubject.create()

    subject.onNext(1)
    subject.onNext(2)
    subject.onNext(3)

    val observer1: Observer<Int> = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            println("Observer 1 has a new subscription")
        }

        override fun onNext(value: Int) {
            println("observer 1 received value: $value")
        }

        override fun onComplete() {
            println("Observable completed")
        }

        override fun onError(e: Throwable) {
            println("Observable encountered an error: $e")
        }
    }

    subject.subscribe(observer1)

    subject.onNext(4)
    subject.onNext(5)

    val observer2: Observer<Int> = object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            println("Observer 2 has a new subscription")
        }

        override fun onNext(value: Int) {
            println("observer 2 received value: $value")
        }

        override fun onComplete() {
            println("Observable completed")
        }

        override fun onError(e: Throwable) {
            println("Observable encountered an error: $e")
        }
    }

    subject.subscribe(observer2)

}
