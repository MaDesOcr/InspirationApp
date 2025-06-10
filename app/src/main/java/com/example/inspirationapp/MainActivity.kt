package com.example.inspirationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.inspirationapp.navigation.NavGraph
import com.example.inspirationapp.ui.theme.InspirationAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InspirationAppTheme {
                NavGraph()
            }
        }
    }
}