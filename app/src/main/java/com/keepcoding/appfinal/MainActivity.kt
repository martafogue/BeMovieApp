package com.keepcoding.appfinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.keepcoding.appfinal.navigation.NavigationGraph
import com.keepcoding.appfinal.presentation.theme.AppFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFinalTheme(
                dynamicColor = false
            ) {
                NavigationGraph()
            }
        }
    }
}
