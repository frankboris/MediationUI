package com.frankboris.mediationui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.res.stringResource
import com.frankboris.mediationui.R

private object HomeTAbDestinations {
    const val HOME_ROUTE = "home/index"
    const val MEDITATE_ROUTE = "home/meditate"
    const val SLEEP_ROUTE = "home/sleep"
    const val MUSIC_ROUTE = "home/music"
    const val PROFILE_ROUTE = "home/profile"
}

enum class HomeTabs(
    @StringRes val title: Int,
    @DrawableRes val iconId: Int,
    val route: String
) {
    HOME_TAB(R.string.home, R.drawable.ic_home, HomeTAbDestinations.HOME_ROUTE),
    MEDITATE_TAB(R.string.meditate, R.drawable.ic_meditation, HomeTAbDestinations.MEDITATE_ROUTE),
    SLEEP_TAB(R.string.sleep, R.drawable.ic_moon, HomeTAbDestinations.SLEEP_ROUTE),
    MUSIC_TAB(R.string.music, R.drawable.ic_music, HomeTAbDestinations.MUSIC_ROUTE),
    PROFILE_TAB(R.string.profile, R.drawable.ic_user, HomeTAbDestinations.PROFILE_ROUTE)
}