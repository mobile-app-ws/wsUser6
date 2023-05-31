package com.example.worldskillsapp.presentation.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun SignIn(){
    SignInContent()
}

@Composable
fun SignInContent(){

}

@Preview
@Composable
fun SignInPreview(){
    SignIn()
}