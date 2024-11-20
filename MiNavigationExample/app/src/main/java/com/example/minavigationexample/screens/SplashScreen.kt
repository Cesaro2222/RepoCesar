package com.example.minavigationexample.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.minavigationexample.Navigation.AppScreens
import com.example.minavigationexample.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.popBackStack()
        navController.navigate(AppScreens.MainScreen.route)
    }
    Splash()
}

@Composable
fun Splash(){
    Column (modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Splash image",
            modifier = Modifier
                .size(128.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = colorResource(R.color.purple_500))
        )
        Spacer(
            modifier = Modifier.size(16.dp)
        )
        Text(
            "Cargando recursos...",
            color = colorResource(R.color.purple_200)
        )
    }
}

