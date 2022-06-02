package com.frankboris.mediationui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.frankboris.mediationui.model.MenuModel
import com.frankboris.mediationui.ui.components.BottomMenu
import com.frankboris.mediationui.ui.screens.HomeScreen
import com.frankboris.mediationui.ui.theme.MediationUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MediationUITheme(darkTheme = false) {
                Scaffold(
                    bottomBar = {
                        BottomAppBar(Modifier.height(70.dp)) {
                            BottomMenu(
                                items = listOf(
                                    MenuModel("Home", R.drawable.ic_home),
                                    MenuModel("Meditate", R.drawable.ic_bubble),
                                    MenuModel("Sleep", R.drawable.ic_moon),
                                    MenuModel("Music", R.drawable.ic_music),
                                    MenuModel("Profile", R.drawable.ic_profile),
                                )
                            )
                        }
                    }
                ) { innerPadding ->
                    Column(Modifier.padding(innerPadding).fillMaxSize()) {
                        HomeScreen()
                    }
                }
            }
        }
    }
}
