package com.frankboris.mediationui.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CodeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(code: Code)

    @Query("SELECT * FROM code ORDER BY id DESC")
    fun getAll(): Flow<List<Code>>

    @Query("SELECT * FROM code WHERE type = :type ORDER BY id DESC")
    fun getByType(type: String): Flow<List<Code>>
}