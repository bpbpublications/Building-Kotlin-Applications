package chapter_03.inheritance

open class Person {
    var name: String? = null
    var age: Int? = null
    var sex: String? = null

    fun work() {
        println("$name is working!")
    }

    fun eat() {
        println("$name is eating!")
    }

    fun sleep() {
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
}

fun main() {
    val teacher = Teacher()
    teacher.name = "Ameer Khan"
    teacher.age = 45
    teacher.sex = "Male"
    teacher.subject = "Math"
    println("-- Teacher --")
    println(teacher.toString())
    teacher.work()
    teacher.teach()
    teacher.eat()
    teacher.sleep()
    println("-------------")


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
    println("-------------")

    val driver = Driver()
    driver.name = "Karim Rafi"
    driver.age = 30
    driver.sex = "Male"
    driver.license = "N202203"
    println("-- Driver --")
    println(driver.toString())
    driver.work()
    driver.drive()
    driver.eat()
    driver.sleep()
    println("-------------")

}