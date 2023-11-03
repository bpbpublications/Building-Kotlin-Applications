package com.mboussetta.todoapp

import com.mboussetta.todoapp.presentation.TaskListViewModel

expect class AppModule {
    val taskListViewModel: TaskListViewModel
}