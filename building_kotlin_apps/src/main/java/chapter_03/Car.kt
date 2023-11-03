package chapter_03

class Car {
    var model: String? = null
    var color: String = "Black"
    var speed: Float = 0f
    var category: String? = null
    var running: Boolean = false

    fun run() {
        running = true
    }

    fun accelerate() {
        if (running) speed = speed.plus(1f)
    }

    fun stop() {
        running = false
    }

    fun brake() {
        if(speed <= 0f) speed = 0f
        else if (running) speed = speed.minus(1f)
    }

    fun displayCarDetails() {
        println("Car model: $model \nColor: $color \nSpeed: $speed \nCategory: $category \nRunning: $running")
    }
}