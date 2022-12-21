package com.frankboris.mediationui.feature_setting.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SettingItem(
    left: @Composable () -> Unit = {},
    right: @Composable () -> Unit = {},
    title: String = "Titre",
    description: String = "Description",
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .clickable { onClick() }
            .padding(horizontal = 15.dp, vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        left()
        Column(modifier = Modifier.weight(1f).padding(horizontal = 30.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold)
            Text(text = description, style = MaterialTheme.typography.caption)
        }
        right()
    }
}