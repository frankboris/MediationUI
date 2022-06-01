package com.frankboris.mediationui.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.frankboris.mediationui.model.Feature
import com.google.accompanist.flowlayout.FlowMainAxisAlignment
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.SizeMode

@Composable
fun FlowGrid(features: List<Feature>) {
    val itemSize: Int = (LocalConfiguration.current.screenWidthDp / 2) - 5
    FlowRow(
        mainAxisSize = SizeMode.Expand,
        mainAxisAlignment = FlowMainAxisAlignment.SpaceBetween,
        modifier = Modifier.padding(horizontal = 5.dp)
    ) {
        for (feature in features) {
            FeatureItem(feature, size = itemSize)
        }
    }
}