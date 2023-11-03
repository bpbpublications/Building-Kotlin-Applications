package chapter_09.mapping

import chapter_09.grouping.Person
import io.reactivex.rxjava3.core.Observable

fun main() {
    val people: Observable<Person> = Observable.fromArray(
        Person("Jane", 25),
        Person("John", 35),
        Person("Sarah", 25)
    )

    val names = people.map { p -> p.name }
    names.subscribe { println(it) }
}
