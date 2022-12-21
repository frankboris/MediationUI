package com.frankboris.mediationui.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FeatureSectionHeader(
    goToSettings: () -> Unit
) {
    Column(Modifier.statusBarsPadding()) {
        GreetingSection(goToSettings = goToSettings)
        ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression", "Concentration"))
        CurrentMeditation()
    }
}