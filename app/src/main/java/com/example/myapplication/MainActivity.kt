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
import com.example.authentication.LoginScreen
import com.example.authentication.SignupScreen
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
    NavHost(navController = navController, startDestination = "Signup") {
        composable("Signup") { SignupPage(navController = navController) }
        composable("Login") { LoginPage(navController) }

    }
}
@Composable
private fun LoginPage(navController: NavHostController) {
    LoginScreen{
        navController.popBackStack()
    }
}
@Composable
private fun SignupPage(navController: NavHostController) {
    SignupScreen(navController){
        navController.navigate("Login")
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
    MainComposable()

}