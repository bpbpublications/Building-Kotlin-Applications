package chapter_11

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.TestScheduler
import io.reactivex.rxjava3.subscribers.TestSubscriber
import org.junit.Test
import java.util.concurrent.TimeUnit

class MyTestScheduler {
    @Test
    fun `should emit values with a custom scheduler`() {
        val testScheduler = TestScheduler()
        val flowable = Flowable.intervalRange(0, 3, 0, 1000, TimeUnit.MILLISECONDS, testScheduler)
        val testSubscriber = TestSubscriber<Long>()

        flowable.subscribe(testSubscriber)

        testScheduler.advanceTimeBy(1500, TimeUnit.MILLISECONDS)

        // Write assertions about the emitted events
        testSubscriber.assertValues(0, 1)
        testSubscriber.assertNotComplete()

        testScheduler.advanceTimeBy(1000, TimeUnit.MILLISECONDS)

        // Write assertions about the emitted events
        testSubscriber.assertValues(0,1,2)
        testSubscriber.assertComplete()
    }

}
