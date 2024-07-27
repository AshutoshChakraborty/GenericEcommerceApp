package com.example.core.ui

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.core.theme.metropolis
import com.example.core.theme.textGrey

@Composable
fun TransparentTextField(textValue: String, lable: String, modifier: Modifier, color: Color) {
    TextField(
        value = textValue,
        onValueChange = {

        },
        label = {
            Text(
                text = lable,
                fontSize = 14.sp,
                color = color,
                fontFamily = metropolis,
                fontWeight = FontWeight.Normal
            )
        },
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            disabledContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}