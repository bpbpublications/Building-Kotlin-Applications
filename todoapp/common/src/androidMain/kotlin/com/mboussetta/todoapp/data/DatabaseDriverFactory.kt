package com.mboussetta.todoapp.data

import android.content.Context
import com.mboussetta.todoapp.database.TaskDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(TaskDatabase.Schema, context, "tasks.db")
    }
}