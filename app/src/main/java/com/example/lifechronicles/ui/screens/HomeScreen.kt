package com.example.lifechronicles.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
import com.example.lifechronicles.ui.state.CategoryUIState
import com.example.lifechronicles.ui.state.EventsUIState
import com.example.lifechronicles.ui.viewModel.CategoryViewModel
import com.example.lifechronicles.ui.viewModel.RecoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    recoViewModel: RecoViewModel = RecoViewModel(),
    categoryViewModel: CategoryViewModel = CategoryViewModel()
) {
    val eventsState by recoViewModel.uiState.collectAsState()
    val categoriesState by categoryViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.welcome),
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
                lineHeight = 35.sp,
                textAlign = TextAlign.Center,
                fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 5.dp, top = 3.dp)

            )
            when (val state = categoriesState) {
                is CategoryUIState.Success -> {
                    CategoriesGrid(
                        modifier = Modifier.weight(3F),
                        categoryList = state.categories,
                        navController = navController,
                    )
                }

                is CategoryUIState.Error -> {
                    TODO()
                }
            }

            Text(
                text = stringResource(id = R.string.recommendations),
                fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 5.dp)
            )
            AppDivider()
            Spacer(modifier = Modifier.height(10.dp))
            when (val state = eventsState) {
                is EventsUIState.Success -> {
                    RecommendationList(
                        modifier = Modifier.height(200.dp),
                        recoList = state.events,
                        navController = navController,
                    )
                }

                is EventsUIState.Error -> {
                    TODO()
                }
            }
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