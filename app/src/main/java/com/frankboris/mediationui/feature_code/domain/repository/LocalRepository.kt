package com.frankboris.mediationui.feature_code.domain.repository

import com.frankboris.mediationui.model.Code
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    fun insertCode(code: Code)

    fun getAllCodes(): Flow<List<Code>>

    fun getCodesByType(type: String): Flow<List<Code>>
}