package chapter_06

sealed class Node<out T> {
    companion object {
        fun <T> of(vararg items: T): Node<T> {
            val tail = items.sliceArray(1 until items.size)
            return if (items.isEmpty()) Nil else SLL(items[0], of(*tail))
        }

        fun sum(items: Node<Int>): Int {
            return when(items) {
                is Nil -> 0
                is SLL -> items.head + sum(items.tail)
            }
        }

        fun product(items: Node<Double>): Double {
            return when(items) {
                is Nil -> 1.0
                is SLL -> if (items.head == 0.0) 0.0 else items.head * product(items.tail)
            }
        }

        fun <T> tail(node: Node<T>):Node<T> =
            when(node) {
                is SLL -> node.tail
                is Nil -> throw IllegalStateException("Nil node doesn't contain a tail.")
            }


        fun <T> setHead(node: Node<T>, newHead: T):Node<T> =
            when(node) {
                is Nil -> throw IllegalStateException(
                    "Cannot replace a head of Nil node")
                is SLL -> SLL(newHead, node.tail)
            }

        tailrec fun <T> dropWhile(node: Node<T>, fn: (T) -> Boolean): Node<T> =
            when (node) {
                is SLL -> if (fn(node.head)) dropWhile(node.tail, fn) else node
                is Nil -> node
            }

        tailrec fun <T> printValues(node: Node<T>) {
            if (node is Nil) return
            else if (node is SLL) {
                print(node.head)
                printValues(node.tail)
            }
        }

    }
}

object Nil: Node<Nothing>()
data class SLL<out T>(val head: T, val tail:Node<T> = Nil): Node<T>()

fun main() {
    val node1: Node<Double> = Nil
    val node2: Node<Int> = SLL(1)
    val node3: Node<String> = SLL("A", SLL("B"))

    val ints = Node.of(1,2,3,4)
    val doubles = Node.of(1.21,2.56,3.14,4.89)

    println(Node.sum(ints))
    println(Node.product(doubles))
}