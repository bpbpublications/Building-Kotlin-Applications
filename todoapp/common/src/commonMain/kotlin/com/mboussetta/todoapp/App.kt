package com.mboussetta.todoapp

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mboussetta.todoapp.presentation.TaskListScreen
import com.mboussetta.todoapp.ui.theme.TaskAppTheme


@Composable
fun App(appModule: AppModule) {
    TaskAppTheme(false) {
        Surface(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
            TaskListScreen(appModule.taskListViewModel)
        }
    }
}