package com.example.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.R
import com.example.core.modifier.colorFullShadow
import com.example.core.theme.appRed
import com.example.core.theme.appRedWithAlpha
import com.example.core.theme.metropolis

@Composable
fun SubmitButton(modifier: Modifier, buttonLebel: String) {
    Box(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = buttonLebel,
            fontSize = 14.sp,
            fontFamily = metropolis,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )

    }
}

@Preview
@Composable
fun PreviewSubmitButton() {
    SubmitButton(
        Modifier
            .padding(start = 16.dp, end = 16.dp, top = 28.dp)
            .colorFullShadow(
                appRedWithAlpha,
                offsetY = 12.dp,
                borderRadius = 25.dp,
                spread = 3.dp,
                blurRadius = 5.dp
            )
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(50))
            .background(color = appRed)
            ,
        stringResource(id = R.string.hello_world).uppercase()
    )
}