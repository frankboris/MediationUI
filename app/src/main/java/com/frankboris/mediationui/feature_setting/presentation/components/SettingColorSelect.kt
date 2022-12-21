package com.frankboris.mediationui.feature_setting.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.frankboris.mediationui.ui.components.ColorChooserDialog

@Composable
fun SettingColorSelect(
    title: String,
    description: String,
    dialogTitle: String,
    value: Long,
    onSelectionChange: (c: Long) -> Unit,
    options: List<Long> = listOf()
) {
    val multiDialog = remember { mutableStateOf(false) }
    SettingItem(
        left = {
            Icon(
                imageVector = Icons.Outlined.Person,
                modifier = Modifier.size(30.dp),
                contentDescription = "backIcon"
            )
        },
        onClick = {
            multiDialog.value = true
        },
        title = title,
        description = description,
        right = {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(100))
                    .background(Color(value))
            )
        }
    )
    if (multiDialog.value) {
        ColorChooserDialog(
            title = dialogTitle,
            options = options,
            value = value,
            onSelectionChange = onSelectionChange,
            onDismiss = { multiDialog.value = false }
        )
    }
}