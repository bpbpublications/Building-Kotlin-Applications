package chapter_06

import java.io.File
import java.time.LocalTime
import java.time.format.DateTimeFormatter

sealed class Try<A> {
    companion object {
        operator fun <A> invoke(fn: () -> A): Try<A> = try {
            Success(fn())
        } catch (e: Exception) {
            Failure(e)
        }
    }

    abstract fun <R> map(transformer: (A) -> R): Try<R>
    abstract fun <R> flatMap(fn: (A) -> Try<R>): Try<R>
}



data class Success<A>(val value: A) : Try<A>() {
    override fun <R> map(transformer: (A) -> R): Try<R> = Try { transformer(value) }

    override fun <R> flatMap(fn: (A) -> Try<R>): Try<R> =
        Try {fn(value)}.let {
            when(it) {
                is Success -> it.value
                is Failure -> it as Try<R>
            }
        }
}



data class Failure<A>(val exception: Exception) : Try<A>() {
    override fun <R> map(transformer: (A) -> R): Try<R> = this as Try<R>
    override fun <R> flatMap(fn: (A) -> Try<R>): Try<R> = this as Try<R>
}


//fun main() {
//    val res1: Try<Double> = Try {  1.0 / 2 }
//    val res2: Try<Double> = Try { throw ArithmeticException("Operation not allowed!") }
//
//    println(res1)
//    println(res2)
//}


data class Task(
    val name: String,
    val status: TaskStatus,
    val plannedTime: LocalTime
)

enum class TaskStatus(val status: String) {
    Waiting("Waiting"),
    Completed("Completed"),
    Archived("Archived");

    companion object {
        private val statuses = TaskStatus.values().associateBy(TaskStatus::status)
        fun fromString(status: String) = Try { statuses[status]
            ?: throw NoSuchElementException("Status $status not found!") }
    }
}

fun toTask(values: List<String>): Try<Task> {
    val name = values[0]
    val plannedTimeTry = Try { LocalTime.parse(values[1], DateTimeFormatter.ofPattern("HH:mm")) }
    val statusTry = TaskStatus.fromString(values[2])

    return plannedTimeTry.flatMap { plannedTime ->
        statusTry.map { status ->
            Task(name, status, plannedTime)
        }
    }
}

fun main() {

    val lines = Try {
        File("./tasks.csv").readLines().map { it.split(",") }
    }

    val tasks: Try<List<Try<Task>>> = lines.map { it.map(::toTask) }

    when(tasks) {
        is Success -> println(tasks.value)
        is Failure -> println(tasks.exception)
    }
}