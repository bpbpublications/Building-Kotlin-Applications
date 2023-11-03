package chapter_02.kotlin

fun main() {

    for (x in 1..10) {
        if (x == 7) break
        println(x)
    }

    val columns = listOf(1,2,3,4,5)
    val rows = listOf(1,2,3,4,5)

    outer@ for (col in columns) {
        inner@ for (row in rows) {
            if (row > col) break@outer
            println("($row, $col)")
        }
    }

    here@ for (col in columns) {
        for (row in rows) {
            if (row > col) continue@here
            println("($row, $col)")
        }
    }

    var i = 100
    while (i > 0) {
        // code here
        if (i == 10) continue
        // code continue here
    }


}

fun doSomething0() {
    (1..10).forEach {
        if (it == 5) return // return from the outer function doSomething
        println(it)
    }
    println("This line will not execute!")
}

fun doSomething1() {
    (1..10).forEach innerLoop@ {
        if (it == 5) return@innerLoop // return from teh forEach loop and not from the outer function doSomething
        println(it)
    }
    println("This line will be printed!")
}

fun doSomething() {
    (1..10).forEach(fun (value) {
        if (value == 5) return // return from teh forEach loop and not from the outer function doSomething
        println(value)
    })
    println("This line will be printed!")
}
