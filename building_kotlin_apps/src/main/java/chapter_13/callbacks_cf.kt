package chapter_13

import java.io.File
import java.util.concurrent.CompletableFuture

fun readFileAsync(file: File): CompletableFuture<String> {
    return CompletableFuture.supplyAsync {
        val content = file.readText()
        Thread.sleep(5000)
        content
    }.exceptionally {
        println(it.message)
        "Error reading file content!"
    }
}

fun main() {
    println("Start")

    val file = File("tasks.csv")
    readFileAsync(file).thenAccept { content ->
        println("File content: $content")
    }

    println("End")
    Thread.sleep(6000) // Wait for the CompletableFuture to complete

    println("Done")
}
