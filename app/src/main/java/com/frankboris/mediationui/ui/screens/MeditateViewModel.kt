package com.frankboris.mediationui.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frankboris.mediationui.feature_code.domain.repository.LocalRepository
import com.frankboris.mediationui.feature_code.domain.repository.RemoteRepository
import com.frankboris.mediationui.model.Code
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeditateViewModel @Inject constructor(
    private val remoteRepo: RemoteRepository,
    private val localRepo: LocalRepository,
) : ViewModel() {
    var codes by mutableStateOf(emptyList<Code>())

    fun fetAllCodes() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                remoteRepo.fetAllCodes().map {
                    localRepo.insertCode(it.toCode())
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun getCodeByType(type: String) {
        viewModelScope.launch(Dispatchers.IO) {
            localRepo.getCodesByType(type).collect { response ->
                codes = response
            }
        }
    }
}