package chapter_11

import org.junit.Assert.assertEquals
import org.junit.Test


class Counter {
    var value: Int = 0

    fun increment() {
        value++
    }
}

class CounterTest {
    @Test
    fun `increment() should be thread-safe`() {
        val counter = Counter()

        // Create 10 threads to increment the counter
        val threads = (1..10).map {
            Thread {
                for (i in 1..100) {
                    counter.increment()
                }
            }
        }

        // Start all the threads
        threads.forEach { it.start() }

        // Wait for all the threads to complete
        threads.forEach { it.join() }

        // Check that the counter was incremented 1000 times (10 threads x 100 increments)
        assertEquals(1000, counter.value)
    }
}
