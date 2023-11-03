import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.reactive.asFlow

suspend fun main() {
    val numbersObservable = Observable.range(1, 10)
    val numbersFlowable = numbersObservable.toFlowable(BackpressureStrategy.BUFFER)

    numbersFlowable.asFlow()
        .buffer(2)
        .filter { it % 2 == 0 }
        .collect { println(it) } // consume the flowable and print items to the console
}
