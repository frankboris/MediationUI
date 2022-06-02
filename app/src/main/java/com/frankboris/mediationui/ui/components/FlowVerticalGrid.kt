package com.frankboris.mediationui.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.frankboris.mediationui.model.Feature
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun FlowVerticalGrid(features: List<Feature>) {
    val itemSize: Float = (LocalConfiguration.current.screenWidthDp / 2) - 7.5f
    FlowRow(
        Modifier
            .padding(horizontal = 7.5.dp)
            .padding(bottom = 7.5.dp)
    ) {
        features.forEach { item -> FeatureItem(feature = item, size = itemSize) }
    }
}