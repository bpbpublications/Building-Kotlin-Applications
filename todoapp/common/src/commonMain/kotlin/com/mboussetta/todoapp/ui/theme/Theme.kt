package com.mboussetta.todoapp.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColors = lightColorScheme(
    primary = todo_light_primary,
    onPrimary = todo_light_onPrimary,
    primaryContainer = todo_light_primaryContainer,
    onPrimaryContainer = todo_light_onPrimaryContainer,
    secondary = todo_light_secondary,
    onSecondary = todo_light_onSecondary,
    secondaryContainer = todo_light_secondaryContainer,
    onSecondaryContainer = todo_light_onSecondaryContainer,
    tertiary = todo_light_tertiary,
    onTertiary = todo_light_onTertiary,
    tertiaryContainer = todo_light_tertiaryContainer,
    onTertiaryContainer = todo_light_onTertiaryContainer,
    error = todo_light_error,
    errorContainer = todo_light_errorContainer,
    onError = todo_light_onError,
    onErrorContainer = todo_light_onErrorContainer,
    background = todo_light_background,
    onBackground = todo_light_onBackground,
    surface = todo_light_surface,
    onSurface = todo_light_onSurface,
    surfaceVariant = todo_light_surfaceVariant,
    onSurfaceVariant = todo_light_onSurfaceVariant,
    outline = todo_light_outline,
    inverseOnSurface = todo_light_inverseOnSurface,
    inverseSurface = todo_light_inverseSurface,
    inversePrimary = todo_light_inversePrimary,
    surfaceTint = todo_light_surfaceTint,
    outlineVariant = todo_light_outlineVariant,
    scrim = todo_light_scrim,
)


private val DarkColors = darkColorScheme(
    primary = todo_dark_primary,
    onPrimary = todo_dark_onPrimary,
    primaryContainer = todo_dark_primaryContainer,
    onPrimaryContainer = todo_dark_onPrimaryContainer,
    secondary = todo_dark_secondary,
    onSecondary = todo_dark_onSecondary,
    secondaryContainer = todo_dark_secondaryContainer,
    onSecondaryContainer = todo_dark_onSecondaryContainer,
    tertiary = todo_dark_tertiary,
    onTertiary = todo_dark_onTertiary,
    tertiaryContainer = todo_dark_tertiaryContainer,
    onTertiaryContainer = todo_dark_onTertiaryContainer,
    error = todo_dark_error,
    errorContainer = todo_dark_errorContainer,
    onError = todo_dark_onError,
    onErrorContainer = todo_dark_onErrorContainer,
    background = todo_dark_background,
    onBackground = todo_dark_onBackground,
    surface = todo_dark_surface,
    onSurface = todo_dark_onSurface,
    surfaceVariant = todo_dark_surfaceVariant,
    onSurfaceVariant = todo_dark_onSurfaceVariant,
    outline = todo_dark_outline,
    inverseOnSurface = todo_dark_inverseOnSurface,
    inverseSurface = todo_dark_inverseSurface,
    inversePrimary = todo_dark_inversePrimary,
    surfaceTint = todo_dark_surfaceTint,
    outlineVariant = todo_dark_outlineVariant,
    scrim = todo_dark_scrim,
)


@Composable
fun TaskAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        shapes = shapes,
        content = content
    )
}