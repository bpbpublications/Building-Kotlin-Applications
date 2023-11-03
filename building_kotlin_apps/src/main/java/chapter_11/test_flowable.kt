package chapter_11

import io.reactivex.Flowable
import org.junit.Test

class MyFlowableTest {

    @Test
    fun testFlowableProcessesEvents() {
        val flowable = Flowable.fromArray(1, 2, 3)
        flowable.test()
            .assertResult(1, 2, 3)
    }
}
