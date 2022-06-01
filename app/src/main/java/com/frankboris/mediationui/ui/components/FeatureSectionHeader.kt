package com.frankboris.mediationui.ui.components

import androidx.compose.runtime.Composable

@Composable
fun FeatureSectionHeader() {
    GreetingSection()
    ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression", "Sport"))
    CurrentMeditation()
}