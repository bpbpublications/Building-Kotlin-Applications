package chapter_11

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.observers.TestObserver
import junit.framework.TestCase.assertTrue
import org.junit.Test


class Database {
    private var db: MutableList<String> = mutableListOf()
    fun saveName(name: String) {
        this.db.add(name)
    }

    fun containsName(name: String): Boolean {
        return this.db.contains(name)
    }
    companion object {
        val database = Database()
        fun getInstance(): Database {
            return database
        }
    }
}


fun createUser(name: String): Completable {
    return Completable.create { emitter ->
        val database = Database.getInstance()
        database.saveName(name)
        emitter.onComplete()
    }
}

class TestSaveUser {
    @Test
    fun testSaveUser() {
        val name = "Mounir Boussetta"
        val testObserver = TestObserver<Void>()
        createUser(name).subscribe(testObserver)
        testObserver.assertComplete()
        assertTrue(Database.getInstance().containsName(name))
    }

}
