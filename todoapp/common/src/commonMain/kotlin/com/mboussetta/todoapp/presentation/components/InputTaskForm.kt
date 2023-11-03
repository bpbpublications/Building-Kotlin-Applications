package com.mboussetta.todoapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mboussetta.todoapp.domain.Task

@Composable
fun InputTaskForm(modifier: Modifier = Modifier, onSubmit: (Task) -> Unit) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var taskValue by remember { mutableStateOf("") }
        OutlinedTextField(
            value = taskValue,
            singleLine = true,
            onValueChange = {
                taskValue = it
            },
            shape = RoundedCornerShape(12.dp),
            placeholder = { Text("Type here...") },
            modifier = Modifier.weight(1f),
            trailingIcon = {
                IconButton(
                    enabled = taskValue.isNotEmpty(),
                    onClick = {
                        onSubmit(Task(null, taskValue, false))
                        taskValue = ""
                    }) {
                    Icon(Icons.Filled.Send, contentDescription = "Clear search")
                }
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.AddTask,
                    contentDescription = "Add Task",
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
        )
    }

}