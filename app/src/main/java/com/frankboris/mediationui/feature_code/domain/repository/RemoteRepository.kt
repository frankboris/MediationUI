package com.frankboris.mediationui.feature_code.domain.repository

import com.frankboris.mediationui.model.CodeDto

interface RemoteRepository {
    suspend fun fetAllCodes(): List<CodeDto>
}