package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.theme.ComposePracticeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                MainComposable()
            }
        }
    }




}
@Composable
private fun MainComposable() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") { HomePage(navController) }
        composable("second") { SecondPage(navController) }
    }
}
@Composable
private fun HomePage(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting("Android") {
            navController.navigate("second")
        }
    }
}
@Composable
private fun SecondPage(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.primary
    ) {
        Greeting("Android on Second page") {
            navController.popBackStack()
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onButtonClick: () -> Unit) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Button(onClick = onButtonClick,modifier = Modifier
        .wrapContentHeight()
        .wrapContentWidth(),) {
        Text(text = "Click me again")

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ComposePracticeTheme {
        rememberNavController()
        MainComposable()
    }
}