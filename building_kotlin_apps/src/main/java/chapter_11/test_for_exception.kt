package chapter_11

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

fun divide(p: Int, q: Int): Int {
    if (q == 0) {
        throw IllegalArgumentException("Cannot divide by zero")
    }
    return p / q
}

class TestDivision {
    @Test
    fun testDivide() {
        assertEquals(3, divide(15, 5))
        assertThrows(IllegalArgumentException::class.java) { divide(5, 0) }
    }

}
