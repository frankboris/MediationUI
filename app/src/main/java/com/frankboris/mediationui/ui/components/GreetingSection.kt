package com.frankboris.mediationui.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.frankboris.mediationui.R
import com.frankboris.mediationui.ui.theme.MediationUITheme


@Composable
fun GreetingSection(
    name: String = "Boris Frank",
    goToSettings: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(vertical = 15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.good_morning, name),
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.h2
            )
            Text(
                text = stringResource(R.string.wish_day),
                color = when {
                    MaterialTheme.colors.isLight -> MaterialTheme.colors.onBackground
                    else -> MaterialTheme.colors.onBackground
                },
                style = MaterialTheme.typography.body1
            )
        }
        IconButton(onClick = goToSettings) {
            Icon(
                painter = painterResource(id = R.drawable.ic_settings),
                contentDescription = "Search",
                tint = MaterialTheme.colors.onBackground,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MediationUITheme {
        GreetingSection()
    }
}