package io.devexpert.training.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Playground() {
    val listState = rememberLazyListState()
    val items = (1..50).toList()
    val groupedItems = items.groupBy { it / 10 }

    LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
        groupedItems.forEach { (header, group) ->
            stickyHeader {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    Text(
                        text = "Header ${header * 10}",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
            items(group) { item ->
                Text(
                    text = "Item $item",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}