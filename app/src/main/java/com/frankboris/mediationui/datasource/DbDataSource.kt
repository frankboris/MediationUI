package com.frankboris.mediationui.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.frankboris.mediationui.model.Code
import com.frankboris.mediationui.model.CodeDao

@Database(entities = [Code::class], version = 1)
abstract class DbDataSource : RoomDatabase() {
    abstract fun codeDao(): CodeDao

    companion object {
        const val DATABASE_NAME = "codes_db"
    }
}