package chapter_09.grouping

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observables.GroupedObservable

fun main() {
    val numbers: Observable<Int> = Observable.fromArray(1, 2, 3, 4, 5)
    val grouped: Observable<GroupedObservable<Boolean, Int>> = numbers.groupBy { x -> x % 2 == 0 }

    grouped.subscribe { group ->
        group.subscribe { x ->
            println(if (group.key == true) "Even: $x" else "Odd: $x")
        }
    }
}
