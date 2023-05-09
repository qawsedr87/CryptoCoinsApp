package com.example.kotlinappcodebase.view.coin_details.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun IconImage(
    url: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
) {
    Icon(
        painter = rememberImagePainter(url),
        contentDescription = contentDescription,
        modifier = modifier.size(32.dp),
        tint = Color.Unspecified
    )
}