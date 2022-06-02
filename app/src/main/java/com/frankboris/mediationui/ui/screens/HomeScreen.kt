package com.frankboris.mediationui.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.frankboris.mediationui.R
import com.frankboris.mediationui.model.Feature
import com.frankboris.mediationui.model.MenuModel
import com.frankboris.mediationui.ui.components.BottomMenu
import com.frankboris.mediationui.ui.components.FeatureSection
import com.frankboris.mediationui.ui.theme.*

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {
        Column(modifier = Modifier.weight(1f)) {
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
        /*BottomMenu(items = listOf(
            MenuModel("Home", R.drawable.ic_home),
            MenuModel("Meditate", R.drawable.ic_bubble),
            MenuModel("Sleep", R.drawable.ic_moon),
            MenuModel("Music", R.drawable.ic_music),
            MenuModel("Profile", R.drawable.ic_profile),
        ))*/
    }
}