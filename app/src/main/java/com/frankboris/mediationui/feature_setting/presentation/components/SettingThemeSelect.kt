package com.frankboris.mediationui.feature_setting.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.frankboris.mediationui.R

@Composable
fun SettingThemeSelect(
    isDark: Boolean,
    toggleAppTheme: () -> Unit
) {
    SettingItem(
        left = {
            Icon(
                imageVector = Icons.Outlined.Person,
                modifier = Modifier.size(30.dp),
                contentDescription = "backIcon"
            )
        },
        onClick = toggleAppTheme,
        title = stringResource(R.string.general_theme),
        description = when {
            isDark -> stringResource(R.string.dark)
            else -> stringResource(R.string.light)
        },
    )
}
