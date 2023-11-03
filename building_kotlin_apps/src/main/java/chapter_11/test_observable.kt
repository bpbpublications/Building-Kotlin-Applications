package chapter_11

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Test

class TestObservable {
    @Test
    fun `should emit a single value`() {
        val observable = Observable.just("Ping")
        val testObserver = TestObserver<String>()
        observable.subscribe(testObserver)

        // Check that the expected value was emitted and the Observable completed
        testObserver.assertValue("Ping")
        testObserver.assertComplete()
    }
}
