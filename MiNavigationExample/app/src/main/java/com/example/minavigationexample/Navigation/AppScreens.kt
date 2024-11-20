package com.example.minavigationexample.Navigation

import androidx.compose.runtime.Composable

sealed class AppScreens(val route: String) {
    object SplashScreen: AppScreens("splash_screen")
    object MainScreen: AppScreens("main_screen")
    object SecondScreen: AppScreens("second_screen")
    object ThirdScreen: AppScreens("third_screen")

}