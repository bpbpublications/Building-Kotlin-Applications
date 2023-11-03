package chapter_13

import java.io.File
import java.lang.Thread.sleep

fun readFileAsync(file: File, callback: (String) -> Unit) {
    Thread {
        val content = file.readText()
        sleep(5000)
        callback(content)
    }.start()
}

fun main() {

    println("Start")

    val file = File("tasks.csv")
    readFileAsync(file) { content ->
        println("File content: $content")
    }

    println("End")
}
