package com.example.autumnhackathon.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.autumnhackathon.ui.navigation.AppNavGraph
import com.example.autumnhackathon.ui.navigation.BottomTabs
import com.example.autumnhackathon.ui.theme.backgroundColor
import com.example.autumnhackathon.ui.theme.bottomTabsBackground
import com.example.autumnhackathon.ui.theme.bottomTabsSelectedItem

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppContent() {

    val navController = rememberNavController()
    val tabs = remember { BottomTabs.values() }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
    ) {
        Box(
            contentAlignment = Alignment.BottomCenter
        ) {
            AppNavGraph(
                modifier = Modifier.height(84.dp),
                navController = navController,
            )
            BottomNavBar(navController = navController, tabItems = tabs)
        }
    }
}

@Composable
fun BottomNavBar(navController: NavController, tabItems: Array<BottomTabs>) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomTabsRoutes = remember { BottomTabs.values().map { it.route } }

    val showBottomTabs = currentDestination?.hierarchy?.any { destination ->
        destination.route in bottomTabsRoutes
    } == true

    if (showBottomTabs) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(bottom = 14.dp),
            contentAlignment = Alignment.Center
        ) {
            BottomNavigation(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .clip(CircleShape),
                backgroundColor = bottomTabsBackground,
                elevation = 0.dp
            ) {
                tabItems.forEach { tab ->
                    val isTabSelected =
                        currentDestination?.hierarchy?.any { it.route == tab.route } == true

                    BottomNavigationItem(
                        icon = {
                            Box (
                                modifier = Modifier.size(45.dp).clip(CircleShape).background(if (isTabSelected) bottomTabsSelectedItem else Color.White),
                                contentAlignment = Alignment.Center
                            ){
                                Icon(
                                    painter = painterResource(id = tab.iconRes),
                                    contentDescription = null,
                                    modifier = Modifier,
                                )
                            }
                        },
                        selected = isTabSelected,
                        onClick = {
                            navController.navigate(tab.route) {

                            }
                        },
                    )
                }
            }
        }
    }
}