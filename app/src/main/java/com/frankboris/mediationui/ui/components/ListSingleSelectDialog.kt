package com.frankboris.mediationui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun <T> ListSingleSelectDialog(
    title: String,
    options: List<T> = listOf(),
    onDismiss: () -> Unit,
    renderItem: @Composable (T) -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colors.background),
            backgroundColor = MaterialTheme.colors.background,
            elevation = 10.dp
        ) {
            Column {
                Box(Modifier.padding(horizontal = 20.dp, vertical = 15.dp)) {
                    Text(text = title, style = MaterialTheme.typography.h6)
                }
                Divider(thickness = 1.dp, color = Color.LightGray)
                LazyColumn(
                    modifier = Modifier.heightIn(max = 200.dp),
                    contentPadding = PaddingValues(vertical = 10.dp),
                ) {
                    items(options) { option -> renderItem(option) }
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
                        modifier = Modifier,
                    ) {
                        Text(
                            text = "Fermer",
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
        }
    }
}