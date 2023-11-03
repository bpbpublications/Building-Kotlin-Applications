package chapter_11

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Test

class MyTestObserver {

    @Test
    fun `test observable with TestObserver`() {
        val testObserver = TestObserver<Int>()
        val observable = Observable.fromIterable(1..5)
            .map { it * 2 }

        observable.subscribe(testObserver)

        testObserver
            .assertValues(2, 4, 6, 8, 10)
            .assertNoErrors()
            .assertComplete()
            .assertValueCount(5)
            .assertValueAt(2, 6)
    }

}
