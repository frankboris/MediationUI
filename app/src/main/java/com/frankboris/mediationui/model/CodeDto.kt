package com.frankboris.mediationui.model

data class CodeDto(
    val categories: List<String>,
    val code: String,
    val description: Description,
    val id: Long,
    val title: Title,
    val title_fr: String,
    val type: String,
) {
    fun toCode() = Code(
        id = id,
        code = code,
        title_fr = title.fr,
        title_en = title.en,
        description_fr = description.fr,
        description_en = description.en,
        categories = categories.joinToString(","),
        type = type
    )
}
