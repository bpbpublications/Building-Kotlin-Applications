package chapter_06

import io.reactivex.rxjava3.subjects.PublishSubject
import io.reactivex.rxjava3.subjects.Subject


fun main() {
    var sub: Subject<String> = PublishSubject.create()

    sub.map { isPalindrome(it) }.subscribe {
        println("The word given is ${if (it) "a" else "not a"} palindrome.")
    }

    sub.onNext("level")
    sub.onNext("stage")
}
