package com.example.minavigationexample.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.minavigationexample.screens.MainScreen
import com.example.minavigationexample.screens.SecondScreen
import com.example.minavigationexample.screens.SplashScreen
import com.example.minavigationexample.screens.ThirdScreen

@Composable
fun AppNavigation(){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.SplashScreen.route,
    ){
        composable(AppScreens.SplashScreen.route) {
            SplashScreen(navController)
        }
        composable(AppScreens.MainScreen.route) {
            MainScreen(navController)
        }
        composable(AppScreens.SecondScreen.route + "/{text}", arguments = listOf(navArgument(name = "text"){
            type = NavType.StringType
        })) {
            SecondScreen(navController,it.arguments?.getString("text"))
        }
        composable(AppScreens.ThirdScreen.route + "/{text}", arguments = listOf(navArgument(name = "text"){
            type = NavType.StringType
        })) {
            ThirdScreen(navController, it.arguments?.getString("text"))
        }

    }
}