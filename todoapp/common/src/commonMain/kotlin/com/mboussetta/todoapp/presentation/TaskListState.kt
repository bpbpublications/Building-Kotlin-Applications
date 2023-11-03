package com.mboussetta.todoapp.presentation

import com.mboussetta.todoapp.domain.Task

data class TaskListState(
    var tasks: List<Task> = listOf(),
    var errorMessage: String? = null,
)
