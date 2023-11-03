package chapter_11

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test
fun factorial(n: Int): Int {
    if (n < 0) {
        throw IllegalArgumentException("n must be >= 0")
    }
    var result = 1
    for (i in 2..n) {
        result *= i
    }
    return result
}

class TestFactorial {
    @Test
    fun testFactorial() {
        assertEquals(1, factorial(0))
        assertEquals(1, factorial(1))
        assertEquals(120, factorial(5))
        assertThrows(IllegalArgumentException::class.java) { factorial(-1) }
    }

}

