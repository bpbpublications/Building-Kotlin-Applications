package com.mboussetta.todoapp

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

expect fun getPlatformName(): String

@Composable
fun TextWidget(text: String) {
    Text(text)
}

@Composable
fun MyComposableFunction() {
    TextWidget("Hello, world!")
}
