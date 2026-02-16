package foi.cverglici.wear.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material.*
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import foi.cverglici.core.data.model.wear.WearMenuItem
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush

@Composable
fun MenuScreen(viewModel: MenuViewModel = viewModel()) {
    val menuItems by viewModel.menuItems.collectAsState()

    Scaffold(timeText = { TimeText() }) {
        if (menuItems.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("Nema podataka", style = MaterialTheme.typography.body1)
            }
        } else {
            val groupedItems = menuItems.groupBy { it.mealType }

            ScalingLazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(
                    top = 32.dp,
                    bottom = 32.dp,
                    start = 10.dp,
                    end = 10.dp
                )
            ) {
                groupedItems.forEach { (mealType, items) ->
                    item {
                        Text(
                            text = mealType,
                            style = MaterialTheme.typography.title2,
                            color = MaterialTheme.colors.primary,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }

                    items(items.size) { index ->
                        MenuItemCard(items[index])
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun MenuItemCard(item: WearMenuItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.primary.copy(alpha = 0.3f),
                        MaterialTheme.colors.surface.copy(alpha = 0.5f)
                    )
                )
            )
            .clickable { }
            .padding(12.dp)
    ) {
        Column {
            Text(
                text = item.title,
                style = MaterialTheme.typography.title3,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${item.price} €",
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.primary
                )
                Text(
                    text = "${item.calories} kcal",
                    style = MaterialTheme.typography.body2
                )
            }

            item.description?.let { desc ->
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = desc,
                    style = MaterialTheme.typography.caption1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}