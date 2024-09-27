package io.devexpert.training.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import io.devexpert.training.R

@Composable
fun Playground() {
    val dogImage = ImageBitmap.imageResource(id = R.drawable.dog)
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawImage(dogImage)
    }
}
