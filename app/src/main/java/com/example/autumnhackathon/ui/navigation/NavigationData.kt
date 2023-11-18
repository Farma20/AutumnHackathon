package com.example.autumnhackathon.ui.navigation

import androidx.annotation.DrawableRes
import com.example.autumnhackathon.R

sealed class Navigation(val route: String){
    object InitializationScreen:Navigation(route = "initializationScreen")

    object TasksScreen:Navigation(route = "taskScreen")

    object PointsScreen:Navigation(route = "pointsScreen")

    object ProfileScreen:Navigation(route = "profileScreen")
}

enum class BottomTabs(
    val route: String,
    @DrawableRes val iconRes: Int
) {
    Tasks(Navigation.InitializationScreen.route, R.drawable.tasks_tab),
    Points(Navigation.PointsScreen.route, R.drawable.points_tab),
    Profile(Navigation.ProfileScreen.route, R.drawable.profile_tab),
}