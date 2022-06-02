package com.frankboris.mediationui.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.frankboris.mediationui.model.Feature

@Composable
fun FeatureSection(features: List<Feature>) {
    val scrollState = rememberScrollState()
    Column(modifier = Modifier
        .fillMaxWidth()
        .verticalScroll(scrollState)) {
        FeatureSectionHeader()
        Text(
            text = "Features",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(15.dp)
        )
        FlowVerticalGrid(features)
    }
}