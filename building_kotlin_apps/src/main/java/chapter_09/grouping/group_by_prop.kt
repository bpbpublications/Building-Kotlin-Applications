package chapter_09.grouping

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.observables.GroupedObservable


data class Person(val name: String, val age: Int)

fun main() {
    val people: Observable<Person> = Observable.fromArray(
        Person("John", 25),
        Person("Jane", 35),
        Person("Sarah", 25)
    )
    val grouped: Observable<GroupedObservable<Int, Person>> =
        people.groupBy { person -> person.age }
    grouped.subscribe { group ->
        group.subscribe { person ->
            println(" G-${group.key} : ${person.name}")
        }
    }

    grouped.subscribe { group ->
        group.reduce(0) { age, p ->
            return@reduce age + p.age
        }.subscribe { ageSum: Int ->
            println(group.key.toString() + ": " + ageSum)
        }
    }

}
