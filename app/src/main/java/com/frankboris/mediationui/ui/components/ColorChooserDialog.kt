package com.frankboris.mediationui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ColorChooserDialog(
    title: String,
    value: Long,
    options: List<Long> = listOf(),
    onSelectionChange: (c: Long) -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
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
                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 40.dp),
                    contentPadding = PaddingValues(vertical = 20.dp, horizontal = 20.dp),
                    modifier = Modifier.heightIn(max = 200.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(options) { color ->
                        Box(
                            modifier = Modifier
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(100))
                                .selectable(
                                    selected = value == color,
                                    onClick = {
                                        onDismiss()
                                        onSelectionChange(color)
                                    }
                                )
                                .background(Color(color)),
                            contentAlignment = Alignment.Center
                        ) {
                            if (value == color) {
                                Icon(
                                    imageVector = Icons.Outlined.Check,
                                    contentDescription = "Add",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
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
                        onClick = onDismiss,
                        modifier = Modifier
                    ) {
                        Text(
                            text = "Fermer",
                        )
                    }
                }
            }
        }
    }
}