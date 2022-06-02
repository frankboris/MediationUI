package com.frankboris.mediationui.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frankboris.mediationui.model.MenuModel
import com.frankboris.mediationui.ui.theme.AquaBlue
import com.frankboris.mediationui.ui.theme.ButtonBlue

@Composable
fun BottomMenu(
    items: List<MenuModel>,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    BottomNavigation(modifier = Modifier.height(70.dp)) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                modifier = Modifier.height(70.dp),
                icon = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(if (index != selectedItemIndex) Color.Transparent else ButtonBlue)
                            .padding(7.5.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = item.iconId),
                            contentDescription = item.title,
                            modifier = Modifier.size(if (index == selectedItemIndex) 20.dp else 24.dp)
                        )
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 11.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = if (index != selectedItemIndex) AquaBlue else Color.White
                    )
                },
                selected = index == selectedItemIndex,
                selectedContentColor = Color.White,
                onClick = {
                    selectedItemIndex = index
                },
                alwaysShowLabel = true,
            )
        }
    }
}