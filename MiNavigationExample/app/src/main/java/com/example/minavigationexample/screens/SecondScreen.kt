package com.example.minavigationexample.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.minavigationexample.Navigation.AppScreens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController, text: String?){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {Text("Segunda pantalla")},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver",
                        modifier = Modifier.clickable {
                            //Volver a la pantalla anterior
                            navController.popBackStack()
                        }
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Pantalla tres",
                        modifier = Modifier.clickable {
                            navController.navigate(AppScreens.ThirdScreen.route + "parámetro opcional")
                        }
                    )
                }
            )
        }
    ){
        SecondBodyContent(
            modifier = Modifier.padding(it),
            navController,
            text
        )
    }
}
/*
actions = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "Pantalla tres",
                        modifier = Modifier.clickable {
                            navController.navigate(AppScreens.ThirdScreen.route + "parámetro opcional")
                        }
                    )
                }
 */

@Composable
fun SecondBodyContent(modifier: Modifier, navController: NavController, text: String?) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text("He navegado a la segunda pantalla.")
        text?.let {
            Text("Texto: $it")
        }
        Button(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Volver")
        }
    }
}

@Preview
@Composable
fun prv(){
    val navController = rememberNavController()
    SecondScreen(
        navController,
        text = ""
    )
}