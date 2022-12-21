package com.frankboris.mediationui.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frankboris.mediationui.ui.theme.DarkerButtonBlue
import com.frankboris.mediationui.ui.theme.TextWhite

inline fun Modifier.noRippleClickable(crossinline onClick: ()->Unit): Modifier = composed {
    clickable(indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}

fun Modifier.ignoreHorizontalParentPadding(horizontal: Dp): Modifier {
    return this.layout { measurable, constraints ->
        val overridenWidth = constraints.maxWidth + 2 * horizontal.roundToPx()
        val placeable = measurable.measure(constraints.copy(maxWidth = overridenWidth))
        layout(placeable.width, placeable.height) {
            placeable.place(0, 0)
        }
    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    ScrollableTabRow(
        selectedTabIndex = selectedChipIndex,
        divider = {}, /* Disable the built-in divider */
        edgePadding = 15.dp,
        backgroundColor = Color.Transparent,
        indicator = emptyTabIndicator,
        modifier = Modifier.padding(vertical = 15.dp).ignoreHorizontalParentPadding(15.dp)
    ) {
        chips.forEachIndexed { index, category ->
            Tab(
                selected = index == selectedChipIndex,
                onClick = {
                    selectedChipIndex = index
                },
                selectedContentColor = TextWhite,
            ) {
                ChipSectionContent(
                    text = category,
                    selected = index == selectedChipIndex,
                    modifier = Modifier.padding(
                        end = when (index) {
                            chips.lastIndex -> 0.dp
                            else -> 10.dp
                        }
                    )
                )
            }
        }
    }
}

private val emptyTabIndicator: @Composable (List<TabPosition>) -> Unit = {}

@Composable
fun ChipSectionContent(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        color = when {
            selected -> MaterialTheme.colors.secondary
            else -> DarkerButtonBlue
        },
        contentColor = TextWhite,
        shape = RoundedCornerShape(50.dp),
        modifier = modifier
    ) {
        Text(
            text = text,
            fontSize = 14.sp,
            color = if (selected) TextWhite else TextWhite.copy(alpha = 0.5f),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun ComposablePreview() {
    ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression", "Sport"))
}