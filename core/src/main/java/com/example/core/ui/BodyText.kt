package com.example.core.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.core.R
import com.example.core.theme.metropolis

@Composable
fun BodyText(text: Int, modifier: Modifier) {
    Text(
        stringResource(text),
        fontFamily = metropolis,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewBodyText() {
    BodyText(text = R.string.hello_world, modifier = Modifier.fillMaxWidth())
}