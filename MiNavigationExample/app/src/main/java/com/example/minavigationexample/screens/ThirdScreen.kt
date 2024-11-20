package com.example.minavigationexample.screens

import android.annotation.SuppressLint
import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.minavigationexample.Navigation.AppScreens
import com.example.minavigationexample.R
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ThirdScreen(navController: NavController, text: String?){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(),
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Tercera pantalla")
                    }
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Volver",
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        }
                    )

                }
            )
        }
    ){
        ThirdBodyContent(navController, text)
    }

}

@Composable
fun ThirdBodyContent(navController: NavController, text: String?, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Has llegado a la tercera pantalla")
        text?.let {
            Text("texto importado: $it")
        }
        Button(onClick = {
            navController.navigate(AppScreens.MainScreen.route)
        },
            shape = ButtonDefaults.shape,
            colors = ButtonDefaults.buttonColors(colorResource(R.color.teal_700))
        ) {
            Text("Ir a la pantalla principal")
        }
    }
}

