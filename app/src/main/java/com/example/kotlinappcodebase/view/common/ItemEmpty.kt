package com.example.kotlinappcodebase.view.common

import androidx.compose.foundation.layout.*

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DisabledByDefault

@Composable
fun ItemEmpty(emptyMessage: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(width = 2.dp))

        Icon(
            imageVector = Icons.Filled.DisabledByDefault,
            contentDescription = null,
            modifier = Modifier.size(28.dp)
        )

        Text(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp),
            text = emptyMessage
        )
    }
}