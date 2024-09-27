package io.devexpert.training.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp

object TopWithFooter : Arrangement.Vertical {
    override fun Density.arrange(
        totalSize: Int,
        sizes: IntArray,
        outPositions: IntArray
    ) {
        var y = 0
        sizes.forEachIndexed { index, size ->
            outPositions[index] = y
            y += size
        }
        if (y < totalSize) {
            val lastIndex = outPositions.lastIndex
            outPositions[lastIndex] = totalSize - sizes.last()
        }
    }
}

@Composable
fun Playground() {
    val listState = rememberLazyListState()
    val items = (1..5).toList()

    LazyColumn(
        state = listState,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = TopWithFooter
    ) {

        items(items) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Item $item",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

    }
}