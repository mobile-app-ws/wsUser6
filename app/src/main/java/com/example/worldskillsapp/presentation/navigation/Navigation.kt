package com.example.worldskillsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.worldskillsapp.presentation.view.NavGraphs
import com.example.worldskillsapp.presentation.view.SplashScreen
import com.example.worldskillsapp.presentation.view.StartScreen
import com.example.worldskillsapp.presentation.view.destinations.SignInDestination
import com.example.worldskillsapp.presentation.view.destinations.SplashScreenDestination
import com.example.worldskillsapp.presentation.view.destinations.StartScreenDestination
import com.example.worldskillsapp.presentation.viewModels.SplashScreenViewModel
import com.example.worldskillsapp.presentation.viewModels.StartScreenViewModel
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.manualcomposablecalls.composable
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popUpTo
import org.koin.androidx.compose.getViewModel

@Composable
fun WorldSkillsMedicAppNavigation() {
    val navController = rememberNavController()
    DestinationsNavHost(navGraph = NavGraphs.root, navController = navController) {
        composable(SplashScreenDestination) {
            val viewModel: SplashScreenViewModel = getViewModel()
            val startScreenViewModel: StartScreenViewModel = getViewModel()
            startScreenViewModel.setOnBoardValue(false)
            SplashScreen(navigateOnLoadSuccess = {
                viewModel.checkOnBoardInfo(isTrue = {
                    navController.navigate(SignInDestination) {
                        popUpTo(SplashScreenDestination) {
                            inclusive = true
                        }
                    }
                }, isFalse = {
                    navController.navigate(StartScreenDestination) {
                        popUpTo(SplashScreenDestination) {
                            inclusive = true
                        }
                    }
                })
            })
        }
        composable(StartScreenDestination) {
            val viewModel: StartScreenViewModel = getViewModel()
            viewModel.setOnBoardValue(true)
            StartScreen(confirmOnClick = {
                navController.navigate(SignInDestination) {
                    popUpTo(StartScreenDestination) {
                        inclusive = true
                    }
                }
            })
        }
        composable(SignInDestination) {

        }
    }
}