package com.frankboris.mediationui.feature_setting.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.frankboris.mediationui.feature_setting.data.Language
import com.frankboris.mediationui.feature_setting.domain.util.SettingUtil
import com.frankboris.mediationui.ui.components.ListSingleSelectDialog

@Composable
fun SettingLanguageSelect(
    title: String,
    dialogTitle: String,
    description: String,
    value: Language,
    options: List<Language> = listOf(),
    onSelectionChange: (lang: Language) -> Unit
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
    )
    if (multiDialog.value) {
        ListSingleSelectDialog(
            title= dialogTitle,
            options = options,
            onDismiss = { multiDialog.value = false },
            renderItem = {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = true,
                            onClick = {
                                multiDialog.value = false
                                onSelectionChange(it)
                            }
                        )
                        .padding(vertical = 3.dp, horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = it === value,
                        onClick = {
                            multiDialog.value = false
                            onSelectionChange(it)
                        }
                    )
                    Text(
                        text = SettingUtil.getLanguageName(it),
                        style = MaterialTheme.typography.body1.merge(),
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        )
    }
}