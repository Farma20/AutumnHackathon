package com.example.autumnhackathon.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.autumnhackathon.ui.points.PointsScreen
import com.example.autumnhackathon.ui.profile.ProfileScreen
import com.example.autumnhackathon.ui.task.TaskScreen
import com.example.autumnhackathon.ui.theme.FontOpenSansRegular
import com.example.autumnhackathon.ui.theme.backgroundColor
import com.example.msmgrouptest.ui.sing_in.SingInScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Navigation.InitializationScreen.route,
        modifier = Modifier.background(backgroundColor)
    ){
        composable(route = Navigation.InitializationScreen.route) {
            SingInScreen(
                navigateToDriverProfile = {
                    navController.navigate(Navigation.ProfileScreen.route){
                        popUpTo(0)
                    }
                }
            )
        }

        composable(route = Navigation.TasksScreen.route){
            TaskScreen()
        }

        composable(route = Navigation.PointsScreen.route){
            PointsScreen()
        }

        composable(route = Navigation.ProfileScreen.route){
            ProfileScreen()
        }

    }
}
