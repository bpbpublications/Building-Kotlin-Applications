package chapter_11

import io.reactivex.rxjava3.observers.TestObserver
import io.reactivex.rxjava3.subjects.PublishSubject
import org.junit.Test

class TestSubjects {
    @Test
    fun `should emit values to subscribers`() {
        val subject = PublishSubject.create<String>()
        val testObserver1 = TestObserver<String>()
        val testObserver2 = TestObserver<String>()

        subject.subscribe(testObserver1)
        subject.onNext("Hello")

        subject.subscribe(testObserver2)
        subject.onNext("World")
        subject.onComplete()

        // Check that the expected values were emitted in the correct order to each subscriber
        testObserver1.assertValues("Hello", "World")
        testObserver1.assertComplete()

        testObserver2.assertValue("World")
        testObserver2.assertComplete()
    }
}
