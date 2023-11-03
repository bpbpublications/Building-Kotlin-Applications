package com.mboussetta.todoapp.data

import com.mboussetta.todoapp.database.TaskDatabase
import com.mboussetta.todoapp.domain.Task
import com.mboussetta.todoapp.domain.TaskDataSource

class SqlDelightTaskDataSource(db: TaskDatabase) : TaskDataSource {
    private val queries = db.tasksQueries

    override fun deleteTask(id: Long) {
        queries.deleteTask(id)
    }

    override fun getAllTasks(): List<Task> {
        return queries.getAllTasks().executeAsList().map {
            it.toTask()
        }
    }

    override fun completeTask(id: Long) {
        queries.completeTask(id)
    }

    override fun insertTask(task: Task) {
        queries.insertTask(
            id = task.id,
            title = task.title,
        )
    }
}