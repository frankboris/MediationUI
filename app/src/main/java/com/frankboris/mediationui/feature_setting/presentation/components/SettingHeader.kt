package com.frankboris.mediationui.feature_setting.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingHeader(
    title: String = "Header",
) {
    Text(
        text = title,
        color = MaterialTheme.colors.secondary,
        modifier = Modifier.padding(start = 15.dp, top = 20.dp, bottom = 10.dp, end = 15.dp)
    )
}