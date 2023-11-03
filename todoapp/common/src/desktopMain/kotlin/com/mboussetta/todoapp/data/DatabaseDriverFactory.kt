package com.mboussetta.todoapp.data

import com.mboussetta.todoapp.database.TaskDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver("jdbc:sqlite:tasks.db")
        TaskDatabase.Schema.create(driver)
        return driver
    }
}