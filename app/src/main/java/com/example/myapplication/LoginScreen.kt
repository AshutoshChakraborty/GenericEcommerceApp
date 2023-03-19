package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen() {
    Column {
        TextField(value = "", onValueChange ={})

    }

}


@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}