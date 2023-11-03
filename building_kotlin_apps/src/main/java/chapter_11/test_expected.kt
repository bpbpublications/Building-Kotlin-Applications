package chapter_11


import junit.framework.TestCase.assertEquals
import org.junit.Test

fun add(a: Int, b: Int): Int {
    return a + b
}

class TestAddNumbers {
    @Test
    fun testAdd() {
        val result = add(2, 3)
        assertEquals(5, result)
    }

}
