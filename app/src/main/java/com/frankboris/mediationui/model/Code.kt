package com.frankboris.mediationui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "code")
data class Code(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    @ColumnInfo(name = "title_fr")
    val title_fr: String,

    @ColumnInfo(name = "title_en")
    val title_en: String,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "code")
    val code: String,

    @ColumnInfo(name = "categories")
    val categories: String,

    @ColumnInfo(name = "description_fr")
    val description_fr: String,

    @ColumnInfo(name = "description_en")
    val description_en: String,
) {
    companion object {
        const val TYPE_MTN = "MTN"
        const val TYPE_ORANGE = "ORANGE"
        const val TYPE_NEXTTEL = "NEXTTEL"
        const val TYPE_CAMTEL = "CAMTEL"
    }
}