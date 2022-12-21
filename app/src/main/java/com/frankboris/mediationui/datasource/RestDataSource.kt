package com.frankboris.mediationui.datasource

import com.frankboris.mediationui.model.CodeDto
import retrofit2.http.GET

interface RestDataSource {
    @GET("/kamer-codes/")
    suspend fun fetchAllCodes(): List<CodeDto>

    companion object {
        const val BASE_URL = "https://choeurister.com/"
    }
}