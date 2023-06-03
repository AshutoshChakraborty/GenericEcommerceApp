package com.example.core.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.R
import com.example.core.theme.metropolis

@Composable
fun TitleView(@StringRes text:Int) {
    Text(
        stringResource(text),
        fontFamily = metropolis,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        modifier = Modifier.padding(start = 14.dp, top = 18.dp)
    )
}

@Preview
@Composable
fun PreviewTitleview() {
    TitleView(text = R.string.hello_world)
}