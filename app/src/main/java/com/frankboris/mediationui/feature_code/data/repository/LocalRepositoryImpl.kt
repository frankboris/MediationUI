package com.frankboris.mediationui.feature_code.data.repository

import com.frankboris.mediationui.feature_code.domain.repository.LocalRepository
import com.frankboris.mediationui.model.Code
import com.frankboris.mediationui.model.CodeDao
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val codeDao: CodeDao
) : LocalRepository {
    override fun insertCode(code: Code) = codeDao.insert(code)

    override fun getAllCodes() = codeDao.getAll()

    override fun getCodesByType(type: String) = codeDao.getByType(type)
}