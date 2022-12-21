package com.frankboris.mediationui.feature_setting.data

import kotlinx.serialization.Serializable

@Serializable
data class AppSettings(
    val appTheme: AppTheme = AppTheme.LIGHT,
    val language: Language = Language.FRENCH,
    val secondary: Long = AppColors[0]
)

enum class Language {
    ENGLISH, FRENCH
}

enum class AppTheme {
    DARK, LIGHT
}

val AppColors  = listOf(
    0xff505cf3,
    0xffd50000,
    0xffff4081,
    0xffaa00ff,
    0xff311b92,
    0xff3f51b5,
    0xff2196F3,
    0xff00bcd4,
    0xff009688,
    0xff4caf50,
    0xff76ff03,
    0xffcddc39,
    0xffffd600,
    0xffff6f00,
    0xffe65100,
    0xffbf360c,
    0xff795548,
    0xff3e2723,
    0xff212121,
)