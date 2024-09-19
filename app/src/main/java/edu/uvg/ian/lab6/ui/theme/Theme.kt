package edu.uvg.ian.lab6.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define los colores que usaremos en el tema
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFEF5350), // Rojo principal
    onPrimary = Color.White,     // Texto en rojo
    background = Color(0xFFFFCDD2), // Fondo ligeramente más claro
    onBackground = Color.White   // Texto sobre fondo
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFEF5350), // Rojo principal en modo oscuro
    onPrimary = Color.Black,     // Texto en rojo en modo oscuro
    background = Color(0xFF424242), // Fondo oscuro
    onBackground = Color.White   // Texto sobre fondo oscuro
)

// Aquí se configura el tema
@Composable
fun Lab6Theme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Detecta si el sistema está en modo oscuro
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        typography = Typography, // Tipografía personalizada
        shapes = Shapes,         // Formas redondeadas
        content = content
    )
}
