package com.example.worldskillsapp.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun SignIn(){
    SignInContent()
}

@Composable
fun SignInContent(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text("Sign in", fontSize = 24.sp, color = Color.Green)
    }
}

@Preview
@Composable
fun SignInPreview(){
    SignIn()
}