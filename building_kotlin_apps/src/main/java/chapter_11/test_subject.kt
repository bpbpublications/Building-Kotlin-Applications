package chapter_11
import io.reactivex.subjects.BehaviorSubject
import junit.framework.TestCase.assertEquals
import org.junit.Test

class MySubjectTest {

    @Test
    fun testSubjectEmitsEvents() {
        val subject = BehaviorSubject.create<Int>()

        subject.subscribe { value ->
            assertEquals(1, value)
        }

        subject.onNext(1)
    }
}
