package chapter_11

import junit.framework.TestCase.*
import org.junit.Test


class MathUtil {
    fun add(a: Int, b: Int): Int {
        return a+b
    }
    fun subtract(a: Int, b: Int): Int {
        return a-b
    }
}

class MathUtilTest {
    @Test
    fun testAdd() {
        val mathUtil = MathUtil()

        // Test that 2 + 3 = 5
        assertEquals(5, mathUtil.add(2, 3))

        // Test that adding a negative number works
        assertEquals(2, mathUtil.add(5, -3))

        // Test that adding zero works
        assertEquals(7, mathUtil.add(7, 0))

        // Test that the result is negative
        assertTrue(mathUtil.subtract(3, 4) < 0)

        // Test that adding a large number doesn't cause overflow
        assertEquals(2147483646, mathUtil.add(2147483645, 1))

        // Test that the result is not null
        assertNotNull(mathUtil.add(1, 2))
    }
}
