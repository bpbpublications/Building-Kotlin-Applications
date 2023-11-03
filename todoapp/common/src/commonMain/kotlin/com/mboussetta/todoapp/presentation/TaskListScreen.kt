package com.mboussetta.todoapp.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.mboussetta.todoapp.presentation.components.InputTaskForm
import com.mboussetta.todoapp.presentation.components.TasksList


@Composable
fun TaskListScreen(taskListViewModel: TaskListViewModel) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.onPrimaryContainer
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Spacer(Modifier.width(24.dp))
                Text(
                    "My Tasks",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            }
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            TasksList(
                modifier = Modifier.weight(1f),
                tasks = taskListViewModel.uiState.tasks,
                onCheckedTask = { task, checked ->
                    taskListViewModel.changeTaskChecked(task, checked)
                },
                onCloseTask = { task -> taskListViewModel.deleteTask(task.id) }
            )
            InputTaskForm(
                modifier = Modifier.padding(horizontal = 16.dp),
                onSubmit = {
                    taskListViewModel.insertTask(it)
                }
            )
        }

    }

}