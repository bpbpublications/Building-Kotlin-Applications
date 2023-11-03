package com.mboussetta.todoapp.domain

interface TaskDataSource {
    fun deleteTask(id: Long)
    fun completeTask(id: Long)
    fun insertTask(task: Task)
    fun getAllTasks(): List<Task>
}