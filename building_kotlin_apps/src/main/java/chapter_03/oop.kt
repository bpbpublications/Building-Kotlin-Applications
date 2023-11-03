package chapter_03

fun main() {
    var bmw = Car()
    bmw.model = "X6"
    bmw.speed = 360f
    bmw.color = "White"
    bmw.category = "4x4"

    bmw.run()
    bmw.displayCarDetails()
    bmw.accelerate()
    bmw.accelerate()

    bmw.displayCarDetails()

    var adam = Person(10, "M", "Adam Smith")

    val manager = Manager("Adele DOE", 12000.0, 45)

}