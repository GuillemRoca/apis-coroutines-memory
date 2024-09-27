package io.devexpert.training.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

sealed class ListItem {
    data class Header(val title: String) : ListItem()
    data class Content(val text: String) : ListItem()
}

@Composable
fun Playground() {
    val items = listOf(
        ListItem.Header("Header 1"),
        ListItem.Content("Content A"),
        ListItem.Content("Content B"),
        ListItem.Header("Header 2"),
        ListItem.Content("Content C"),
        ListItem.Content("Content D")
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = items, contentType = { it.javaClass }) { item ->
            when (item) {
                is ListItem.Header -> {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.secondary
                    ) {
                        Text(
                            text = item.title,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.headlineSmall
                        )
                    }
                }
                is ListItem.Content -> {
                    Text(
                        text = item.text,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}