package com.example.minavigationexample.screens

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.minavigationexample.Navigation.AppScreens
import com.example.minavigationexample.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController){

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(),
                title = { Text("Primera pantalla") }
                    )
        }
    ) {
       BodyContent(navController,
           modifier = Modifier
           .padding(it))
    }
}

@Composable
fun BodyContent(navController: NavController, modifier: Modifier){
    Column(
        modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Estás en la primera pantalla")
        Button(
            onClick = {
                navController.navigate(AppScreens.SecondScreen.route)
            },
            shape = ButtonDefaults.shape,
            colors = ButtonDefaults.buttonColors(
                colorResource(id = R.color.teal_700)
            ),
        ) {
            Text("Navegar a segunda pantalla")
        }
    }
}


