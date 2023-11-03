package chapter_11

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Test

class TestOperator {
    @Test
    fun `should filter even numbers`() {
        val observable = Observable.just(1, 2, 3, 4, 5, 6)
        val testObserver = TestObserver<Int>()

        observable.filter { it % 2 == 0 }
            .subscribe(testObserver)

        // Check that the expected values were emitted in the correct order
        testObserver.assertValues(2, 4, 6)
        testObserver.assertComplete()
    }
}
