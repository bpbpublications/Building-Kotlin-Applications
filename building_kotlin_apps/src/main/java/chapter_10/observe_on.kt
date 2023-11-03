package chapter_10
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

fun main() {
    val dataSource = 1..10 step 2

    val dataObservable = Observable.create<Int> {
        for (data in dataSource) {
            it.onNext(data)
        }
        it.onComplete()
    }

    dataObservable
        .subscribeOn(Schedulers.io())
        .observeOn(Schedulers.computation())
        .blockingSubscribe { data ->
            updateUI(data)
        }
}

fun updateUI(data: Int) {
    println("New data has come: $data on thread ${Thread.currentThread().name}")
}


