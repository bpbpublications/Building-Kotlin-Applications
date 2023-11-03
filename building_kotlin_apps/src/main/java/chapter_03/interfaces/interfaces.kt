package chapter_03.interfaces

import java.util.Date


interface DatabaseInterface {
    fun findAll()
    fun deleteALl() {
        // Optional body
    }
}

class ChildRepository: DatabaseInterface {
    override fun findAll() {
        // implementation here...
    }
}







interface DemoInterface {
    val myProp: Int // abstract by default

    val myPropWithImplementation: String
        get() = "Kotlin interface"

    fun demo() {
        println(myProp)
        println(myPropWithImplementation)
    }
}

class Child: DemoInterface {
    override val myProp: Int = 2022
}







interface Subscriber {
    val subscriptionNumber: String
}

interface Person: Subscriber {
    val firstName: String
    val lastName: String
    val idCard: String

    override val subscriptionNumber: String
        get() = "2022$idCard@$lastName"
}

data class Visitor(
    // implementing 'subscriptionNumber' is optional
    override val firstName: String,
    override val lastName: String,
    override val idCard: String,

    val lastVisit: Date
): Person