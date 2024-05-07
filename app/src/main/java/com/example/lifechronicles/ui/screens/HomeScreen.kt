package com.example.lifechronicles.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lifechronicles.R
import com.example.lifechronicles.ui.components.AppDivider
import com.example.lifechronicles.ui.components.CategoriesGrid
import com.example.lifechronicles.ui.components.RecommendationList
import com.example.lifechronicles.ui.navigation.graphs.BottomBarScreen
import com.example.lifechronicles.ui.navigation.graphs.HomeNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController = rememberNavController(), onCategoryClick: () -> Unit, onDetailClick: ()-> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.welcomeUser),
                    )
                }
            )
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) {
        Column(
            Modifier.padding(vertical = it.calculateTopPadding(), horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.homeTitle),
                textAlign = TextAlign.Center,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            CategoriesGrid(modifier = Modifier.weight(3F), navController, onClick= onCategoryClick)
            Text(
                text = stringResource(id = R.string.recommendations),
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                modifier = Modifier.padding(vertical = 10.dp)
            )
            AppDivider()
            RecommendationList(modifier = Modifier.weight(2F), onClick = onDetailClick)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Chat,
        BottomBarScreen.Profile,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        selectedContentColor = Color(0xFFFE7F2E2),
        unselectedContentColor = MaterialTheme.colorScheme.tertiary.copy(alpha = ContentAlpha.disabled),
        alwaysShowLabel = true,
        label = {
            Text(text = screen.title,
                color = if (currentDestination?.hierarchy?.any {
                        it.route == screen.route
                    } == true) {
                    MaterialTheme.colorScheme.onSurface
                } else {
                    MaterialTheme.colorScheme.tertiary
                }
            )
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon",
                tint = if (currentDestination?.hierarchy?.any {
                        it.route == screen.route
                    } == true) {
                    MaterialTheme.colorScheme.onSurface
                } else {
                    MaterialTheme.colorScheme.tertiary
                }
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}