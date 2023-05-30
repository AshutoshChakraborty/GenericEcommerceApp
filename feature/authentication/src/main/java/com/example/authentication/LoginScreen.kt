package com.example.authentication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    Column {
        TextField(value = "", onValueChange ={})
        Spacer(modifier = Modifier.width(25.dp))
        Button(onClick = {}){
            Text("Login")
        }
    }

}


@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}