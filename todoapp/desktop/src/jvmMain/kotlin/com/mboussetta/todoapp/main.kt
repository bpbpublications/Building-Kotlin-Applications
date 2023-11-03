
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.mboussetta.todoapp.App
import com.mboussetta.todoapp.AppModule

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Todo App") {
            App(AppModule())
    }
}

