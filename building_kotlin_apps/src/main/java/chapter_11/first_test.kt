package chapter_11

import junit.framework.TestCase.assertNotNull
import org.junit.Test

class MyFirstTest {

    @Test
    fun testStringIsNotNull() {
        val s = "Kotlin is real!"
        assertNotNull(s)
    }
}
