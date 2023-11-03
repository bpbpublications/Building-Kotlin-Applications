package chapter_10
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

fun main() {
    val dataSource: Observable<Int> = Observable.fromIterable(1..10 step 2)

    val dataObservable = dataSource
        .subscribeOn(Schedulers.io())

    dataObservable
        .blockingSubscribe { data ->
            processData(data)
        }
}

fun processData(data: Int) {
    println("Processing data: $data on thread ${Thread.currentThread().name}")
}

