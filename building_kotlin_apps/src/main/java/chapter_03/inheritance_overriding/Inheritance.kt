package chapter_03.inheritance_overriding

open class Person {
    var name: String? = null
    var age: Int? = null
    var sex: String? = null

    var hasPermission: Boolean = false
        get() {
            if (!field) println("$name need a permission to work.")
            return field
        }
        set(value) {
            if ( value && age!! > 18) {
                field = value
            } else field = false
        }

    var defaultTitle: String = "M"
        get() { // getter
            return field
        }
        set(value) { // setter
            field = value
        }

    fun work() {
        println("$name is working!")
    }

    fun eat() {
        println("$name is eating!")
    }

    open fun sleep() {
        println("$name is sleeping!")
    }

    override fun toString(): String {
        return "Name: $name\nAge: $age\nSex: $sex"
    }
}

class Teacher: Person() {
    var subject: String? = null

    fun teach() {
        println("I am teaching $subject")
    }
}

class Driver: Person() {
    var license: String? = null

    fun drive() {
        println("I am driving a car !")
    }
}

class Doctor: Person() {
    var specialty: String? = null

    fun treat() {
        println("I am treating people !")
    }

    override fun sleep() {
        println("I don't sleep enough")
    }
}

fun main() {
    val doctor = Doctor()
    doctor.name = "Jane Smith"
    doctor.age = 40
    doctor.sex = "Female"
    doctor.specialty = "Cardiologist"

    println("-- Doctor --")
    println(doctor.toString())
    doctor.work()
    doctor.treat()
    doctor.eat()
    doctor.sleep()

    val adam = Person()
    adam.name = "Adam Doe"
    adam.age = 45
    adam.sex = "Male"


}