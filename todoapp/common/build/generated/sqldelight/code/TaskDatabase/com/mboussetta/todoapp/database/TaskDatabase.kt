package com.mboussetta.todoapp.database

import com.mboussetta.todoapp.database.common.newInstance
import com.mboussetta.todoapp.database.common.schema
import com.squareup.sqldelight.Transacter
import com.squareup.sqldelight.db.SqlDriver
import database.TasksQueries

public interface TaskDatabase : Transacter {
  public val tasksQueries: TasksQueries

  public companion object {
    public val Schema: SqlDriver.Schema
      get() = TaskDatabase::class.schema

    public operator fun invoke(driver: SqlDriver): TaskDatabase =
        TaskDatabase::class.newInstance(driver)
  }
}
