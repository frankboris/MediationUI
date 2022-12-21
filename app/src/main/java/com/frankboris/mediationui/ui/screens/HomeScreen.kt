package com.frankboris.mediationui.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.frankboris.mediationui.R
import com.frankboris.mediationui.model.Feature
import com.frankboris.mediationui.ui.components.FeatureSection
import com.frankboris.mediationui.ui.theme.*

@Composable
fun HomeScreen(
    onFeatureClick: () -> Unit,
    goToSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    FeatureSection(
        features = getFeatures(),
        modifier = modifier,
        goToSettings = goToSettings,
        onFeatureClick = onFeatureClick,
    )
}

fun getFeatures(): List<Feature> {
    return listOf(
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
}