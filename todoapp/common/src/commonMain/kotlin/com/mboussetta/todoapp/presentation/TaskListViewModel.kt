package com.mboussetta.todoapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.mboussetta.todoapp.domain.Task
import com.mboussetta.todoapp.domain.TaskDataSource
import dev.icerock.moko.mvvm.viewmodel.ViewModel


class TaskListViewModel(private val taskDataSource: TaskDataSource) : ViewModel() {

    var uiState by mutableStateOf(TaskListState())

    init {
        loadAllTasks()
    }

    private fun loadAllTasks() {
        uiState = uiState.copy(tasks = taskDataSource.getAllTasks())
    }

    fun changeTaskChecked(item: Task, checked: Boolean) =
        taskDataSource.completeTask(item.id!!)

    fun deleteTask(id: Long?) {
        taskDataSource.deleteTask(id!!).also { loadAllTasks() }
    }

    fun insertTask(task: Task) {
        taskDataSource.insertTask(task).also { loadAllTasks() }
    }

}
