package com.frankboris.mediationui.feature_setting.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun SettingListSingleSelect(
    title: String,
    options: List<String> = listOf(),
    state: MutableState<Boolean>
) {
    Dialog(onDismissRequest = {state.value = false}) {
        Card(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colors.background),
            elevation = 10.dp
        ) {
            Column {
                Box(Modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
                    Text(text = title, style = MaterialTheme.typography.h6)
                }
                Divider(thickness = 1.dp, color = Color.LightGray)
                LazyColumn(Modifier.heightIn(max = 200.dp).padding(vertical = 5.dp)) {
                    itemsIndexed(options) { _, text ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .selectable(
                                    selected = true,
                                    onClick = {}
                                )
                                .padding(vertical = 3.dp, horizontal = 10.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = false,
                                onClick = { }
                            )
                            Text(
                                text = text,
                                style = MaterialTheme.typography.body1.merge(),
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
                Divider(thickness = 1.dp, color = Color.LightGray)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = {state.value = false},
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Cancel",
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    TextButton(
                        onClick = {state.value = false},
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Ok",
                        )
                    }
                }
            }
        }
    }
}