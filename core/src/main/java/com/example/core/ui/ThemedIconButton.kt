package com.example.core.ui

import androidx.compose.foundation.Image
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun ThemedIconButton(imageResource: Int,contentDescription:String,onClick: () -> Unit ) {
    IconButton(onClick = onClick) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = contentDescription
        )
    }
}
