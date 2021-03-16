package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.theme.MyTheme


const val SCREEN_WELCOME = "welcome"
const val SCREEN_LOGIN = "login"
const val SCREEN_HOME = "home"

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = SCREEN_WELCOME) {
        composable(route = SCREEN_WELCOME) {
            WelcomeScreen(navController)
        }
        composable(route = SCREEN_LOGIN) {
            LoginScreen(navController)
        }
        composable(route = SCREEN_HOME) {
            HomeScreen()
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}