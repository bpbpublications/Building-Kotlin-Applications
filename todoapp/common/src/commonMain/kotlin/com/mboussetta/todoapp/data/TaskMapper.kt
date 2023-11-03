package com.mboussetta.todoapp.data

import com.mboussetta.todoapp.domain.Task
import database.TaskEntity

fun TaskEntity.toTask(): Task {
    return Task(
        id,
        title,
        complete == 1L
    )
}