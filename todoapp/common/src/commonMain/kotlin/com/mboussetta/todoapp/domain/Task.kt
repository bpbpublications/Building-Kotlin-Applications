package com.mboussetta.todoapp.domain

data class Task(
    val id: Long?,
    val title: String,
    var complete: Boolean,
)
