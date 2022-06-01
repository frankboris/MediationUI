package com.frankboris.mediationui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.frankboris.mediationui.ui.screens.HomeScreen
import com.frankboris.mediationui.ui.theme.MediationUITheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediationUITheme {
                HomeScreen()
            }
        }
    }
}
