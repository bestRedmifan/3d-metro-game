package com.bestredmifan.metrogame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.bestredmifan.metrogame.ui.MetroGameApp
import com.bestredmifan.metrogame.ui.GameTheme

class MetroGameActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameTheme {
                MetroGameApp()
            }
        }
    }
}
