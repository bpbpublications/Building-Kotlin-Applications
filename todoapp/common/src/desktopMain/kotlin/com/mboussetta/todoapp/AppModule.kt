package com.mboussetta.todoapp

import com.mboussetta.todoapp.data.DatabaseDriverFactory
import com.mboussetta.todoapp.data.SqlDelightTaskDataSource
import com.mboussetta.todoapp.database.TaskDatabase
import com.mboussetta.todoapp.presentation.TaskListViewModel

actual class AppModule {
    actual val taskListViewModel: TaskListViewModel by lazy {
        TaskListViewModel(
            SqlDelightTaskDataSource(
                db = TaskDatabase(driver = DatabaseDriverFactory().create())
            )
        )
    }
}