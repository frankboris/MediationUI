package com.frankboris.mediationui.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.frankboris.mediationui.model.Code

@Composable
fun MeditateScreen(
    viewModel: MeditateViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.fetAllCodes()
        viewModel.getCodeByType(Code.TYPE_MTN)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Meditate Screen"+viewModel.codes.size)
    }
}