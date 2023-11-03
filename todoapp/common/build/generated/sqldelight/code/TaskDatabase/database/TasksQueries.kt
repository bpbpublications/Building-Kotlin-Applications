package database

import com.squareup.sqldelight.Query
import com.squareup.sqldelight.Transacter
import kotlin.Any
import kotlin.Long
import kotlin.String
import kotlin.Unit

public interface TasksQueries : Transacter {
  public fun <T : Any> getPendingTasks(mapper: (
    id: Long,
    title: String,
    complete: Long
  ) -> T): Query<T>

  public fun getPendingTasks(): Query<TaskEntity>

  public fun <T : Any> getAllTasks(mapper: (
    id: Long,
    title: String,
    complete: Long
  ) -> T): Query<T>

  public fun getAllTasks(): Query<TaskEntity>

  public fun <T : Any> getCompleteTasks(mapper: (
    id: Long,
    title: String,
    complete: Long
  ) -> T): Query<T>

  public fun getCompleteTasks(): Query<TaskEntity>

  public fun insertTask(id: Long?, title: String): Unit

  public fun deleteTask(id: Long): Unit

  public fun completeTask(id: Long): Unit
}
