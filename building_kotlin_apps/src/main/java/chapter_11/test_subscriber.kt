package chapter_11

import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.subscribers.TestSubscriber
import org.junit.Test


class MyTestSubscriber {
    @Test
    fun testWithSubscriber() {
        val flowable = Flowable.just("Ping")
        val testSubscriber = TestSubscriber<String>()

        flowable.subscribe(testSubscriber)

        // Write assertions about the emitted events
        testSubscriber.assertValue("Ping")
        testSubscriber.assertComplete()
        testSubscriber.assertNoErrors()
    }

}
