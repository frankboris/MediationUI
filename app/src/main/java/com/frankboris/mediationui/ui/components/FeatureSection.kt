package com.frankboris.mediationui.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.frankboris.mediationui.R
import com.frankboris.mediationui.model.Feature

@Composable
fun FeatureSection(
    onFeatureClick: () -> Unit,
    goToSettings: () -> Unit,
    features: List<Feature>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(start = 15.dp, end = 15.dp, bottom = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier.fillMaxSize()
    ) {
        item(span = {
            GridItemSpan(maxLineSpan)
        }) {
            Column {
                FeatureSectionHeader(goToSettings)
                Text(
                    text = stringResource(R.string.features),
                    color = MaterialTheme.colors.onBackground,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.padding(vertical = 15.dp)
                )
            }
        }

        items(features) {
            FeatureItem(feature = it)
        }
    }
}