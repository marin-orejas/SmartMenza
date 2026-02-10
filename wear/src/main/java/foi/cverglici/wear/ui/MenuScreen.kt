package foi.cverglici.wear.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.*

@Composable
fun MenuScreen(
    viewModel: MenuViewModel = viewModel()
) {
    val menuItems by viewModel.menuItems.collectAsState()

    Scaffold(
        timeText = {
            TimeText()
        }
    ) {
        if (menuItems.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text(
                    text = "Nema podataka",
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}