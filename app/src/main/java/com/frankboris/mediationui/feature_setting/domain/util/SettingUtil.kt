package com.frankboris.mediationui.feature_setting.domain.util

import com.frankboris.mediationui.feature_setting.data.Language

class SettingUtil {
    companion object {
        @JvmStatic

        fun getLanguageName(lang: Language): String {
            return when(lang) {
                Language.ENGLISH -> "English"
                else -> "Français"
            }
        }

        fun getLanguageCode(lang: Language): String {
            return when(lang) {
                Language.ENGLISH -> "en"
                else -> "fr"
            }
        }
    }
}