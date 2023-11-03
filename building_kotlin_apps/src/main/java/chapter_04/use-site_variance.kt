package chapter_04


open class Insect

class Spider: Insect()
class Ant: Insect()

fun <T> copyItems(from: MutableList<T>, to: MutableList<in T>) {
    for (element in from) {
        to.add(element)
    }
}

fun main() {
    val spiders = mutableListOf(Spider(), Spider())
    val ants = mutableListOf(Ant())

    val insects = mutableListOf<Insect>()

    copyItems(spiders, insects) // Ok
    copyItems(ants, insects) // Ok

    //copyItems(spiders, ants) // compile time error
}