package com.frankboris.mediationui.feature_code.data.repository

import com.frankboris.mediationui.datasource.RestDataSource
import com.frankboris.mediationui.feature_code.domain.repository.RemoteRepository
import com.frankboris.mediationui.model.CodeDto
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(
    private val api: RestDataSource
) : RemoteRepository {
    override suspend fun fetAllCodes(): List<CodeDto> {
        return api.fetchAllCodes()
    }
}