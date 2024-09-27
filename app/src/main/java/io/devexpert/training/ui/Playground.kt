package io.devexpert.training.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Playground() {
    var items by remember { mutableStateOf((0..4).toList()) }
    var itemCounter by remember { mutableIntStateOf(5) }
    val listState = rememberLazyListState()

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                val insertIndex = if (items.isEmpty()) 0 else items.indices.random()
                items = items.toMutableList().apply { add(insertIndex, itemCounter++) }
            }) {
                Text("Add Item")
            }
            Button(onClick = {
                if (items.isNotEmpty()) {
                    val removeIndex = (items.indices).random()
                    items = items.toMutableList().apply { removeAt(removeIndex) }
                }
            }) {
                Text("Remove Item")
            }
        }
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
            items(
                items,
                key = { it }
            ) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .animateItem()
                ) {
                    Text(
                        text = "Item $item",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}