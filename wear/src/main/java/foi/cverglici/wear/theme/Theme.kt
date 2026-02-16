package foi.cverglici.wear.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color

@Composable
fun WearAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = androidx.wear.compose.material.Colors(
            primary = OrangePrimary,
            primaryVariant = OrangeDark,
            secondary = OrangeLight,
            background = Color(0xFF000000),
            surface = Color(0xFF1E1E1E),
            onPrimary = Color.White,
            onSecondary = Color.White,
            onBackground = Color.White,
            onSurface = Color.White,
            onSurfaceVariant = Color(0xFFBBBBBB)
        ),
        content = content
    )
}