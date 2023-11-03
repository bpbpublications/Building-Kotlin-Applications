package chapter_09

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import java.util.concurrent.TimeUnit


fun main() {
    val searchQueries = Observable.create<String> { emitter ->
        // Simulating user typing in search field
        emitter.onNext("React")
        Thread.sleep(100)
        emitter.onNext("React Native")
        Thread.sleep(300)
        emitter.onNext("React Native Dev")
        Thread.sleep(500)
        emitter.onNext("React Native Development")
        Thread.sleep(300)
        emitter.onNext("React Native Development with Redux")
        Thread.sleep(200)
        emitter.onComplete()
    }

    val filteredQueries = searchQueries.debounce(300, TimeUnit.MILLISECONDS)
    filteredQueries.subscribe { query -> println("Search query: $query") }
}
