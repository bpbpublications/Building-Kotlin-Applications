package com.mboussetta.todoapp.database.common

import com.mboussetta.todoapp.database.TaskDatabase
import com.squareup.sqldelight.Query
import com.squareup.sqldelight.TransacterImpl
import com.squareup.sqldelight.`internal`.copyOnWriteList
import com.squareup.sqldelight.db.SqlDriver
import database.TaskEntity
import database.TasksQueries
import kotlin.Any
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Unit
import kotlin.collections.MutableList
import kotlin.reflect.KClass

internal val KClass<TaskDatabase>.schema: SqlDriver.Schema
  get() = TaskDatabaseImpl.Schema

internal fun KClass<TaskDatabase>.newInstance(driver: SqlDriver): TaskDatabase =
    TaskDatabaseImpl(driver)

private class TaskDatabaseImpl(
  driver: SqlDriver
) : TransacterImpl(driver), TaskDatabase {
  public override val tasksQueries: TasksQueriesImpl = TasksQueriesImpl(this, driver)

  public object Schema : SqlDriver.Schema {
    public override val version: Int
      get() = 1

    public override fun create(driver: SqlDriver): Unit {
      driver.execute(null, """
          |CREATE TABLE IF NOT EXISTS taskEntity (
          |    id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
          |    title TEXT NOT NULL,
          |    complete INTEGER NOT NULL DEFAULT 0
          |)
          """.trimMargin(), 0)
    }

    public override fun migrate(
      driver: SqlDriver,
      oldVersion: Int,
      newVersion: Int
    ): Unit {
    }
  }
}

private class TasksQueriesImpl(
  private val database: TaskDatabaseImpl,
  private val driver: SqlDriver
) : TransacterImpl(driver), TasksQueries {
  internal val getPendingTasks: MutableList<Query<*>> = copyOnWriteList()

  internal val getAllTasks: MutableList<Query<*>> = copyOnWriteList()

  internal val getCompleteTasks: MutableList<Query<*>> = copyOnWriteList()

  public override fun <T : Any> getPendingTasks(mapper: (
    id: Long,
    title: String,
    complete: Long
  ) -> T): Query<T> = Query(1774412048, getPendingTasks, driver, "tasks.sq", "getPendingTasks", """
  |SELECT *
  |FROM taskEntity
  |WHERE complete = 0
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!
    )
  }

  public override fun getPendingTasks(): Query<TaskEntity> = getPendingTasks { id, title,
      complete ->
    TaskEntity(
      id,
      title,
      complete
    )
  }

  public override fun <T : Any> getAllTasks(mapper: (
    id: Long,
    title: String,
    complete: Long
  ) -> T): Query<T> = Query(734084038, getAllTasks, driver, "tasks.sq", "getAllTasks", """
  |SELECT *
  |FROM taskEntity
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!
    )
  }

  public override fun getAllTasks(): Query<TaskEntity> = getAllTasks { id, title, complete ->
    TaskEntity(
      id,
      title,
      complete
    )
  }

  public override fun <T : Any> getCompleteTasks(mapper: (
    id: Long,
    title: String,
    complete: Long
  ) -> T): Query<T> = Query(-1084925924, getCompleteTasks, driver, "tasks.sq", "getCompleteTasks",
      """
  |SELECT *
  |FROM taskEntity
  |WHERE complete = 1
  """.trimMargin()) { cursor ->
    mapper(
      cursor.getLong(0)!!,
      cursor.getString(1)!!,
      cursor.getLong(2)!!
    )
  }

  public override fun getCompleteTasks(): Query<TaskEntity> = getCompleteTasks { id, title,
      complete ->
    TaskEntity(
      id,
      title,
      complete
    )
  }

  public override fun insertTask(id: Long?, title: String): Unit {
    driver.execute(-797421669, """
    |INSERT OR REPLACE
    |INTO taskEntity (id, title)
    |VALUES (?,?)
    """.trimMargin(), 2) {
      bindLong(1, id)
      bindString(2, title)
    }
    notifyQueries(-797421669, {database.tasksQueries.getCompleteTasks +
        database.tasksQueries.getAllTasks + database.tasksQueries.getPendingTasks})
  }

  public override fun deleteTask(id: Long): Unit {
    driver.execute(1001869, """
    |DELETE FROM taskEntity
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id)
    }
    notifyQueries(1001869, {database.tasksQueries.getCompleteTasks +
        database.tasksQueries.getAllTasks + database.tasksQueries.getPendingTasks})
  }

  public override fun completeTask(id: Long): Unit {
    driver.execute(1301709531, """
    |UPDATE taskEntity
    |SET complete = 1
    |WHERE id = ?
    """.trimMargin(), 1) {
      bindLong(1, id)
    }
    notifyQueries(1301709531, {database.tasksQueries.getCompleteTasks +
        database.tasksQueries.getAllTasks + database.tasksQueries.getPendingTasks})
  }
}
