package com.example.worldskillsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.worldskillsapp.presentation.navigation.WorldSkillsMedicAppNavigation
import com.example.worldskillsapp.ui.theme.WorldSkillsAppTheme

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorldSkillsAppTheme {
                Surface {
                    WorldSkillsMedicAppNavigation()
                }
            }
        }
    }
}