package com.mboussetta.todoapp.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mboussetta.todoapp.domain.Task


@Composable
fun TasksList(
    modifier: Modifier = Modifier,
    tasks: List<Task>,
    onCheckedTask: (Task, Boolean) -> Unit,
    onCloseTask: (Task) -> Unit,
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "My Tasks (${tasks.size})",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                fontWeight = FontWeight.Normal,
            )
        }

        items(
            items = tasks,
            key = { task -> task.id!! }
        ) { task ->
            TaskListItem(task = task,
                onCheckedChange = { checked -> onCheckedTask(task, checked) },
                onDelete = { onCloseTask(task) }
            )
        }
    }
}