package com.foodfacil.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.wear.compose.material.ContentAlpha
import com.foodfacil.enums.BottomBarScreen
import com.foodfacil.services.Print

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Cardapio,
        BottomBarScreen.Pedidos,
        BottomBarScreen.Perfil,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        BottomNavigation(modifier = Modifier.navigationBarsPadding(), backgroundColor = Color.White,
            elevation = 0.dp,) {
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

    val print = Print("BOTTOMBAR")
    val  selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true

    print.log("selected: ${currentDestination?.route}")

    BottomNavigationItem(
        label = {
            Text(text = screen.title,
                color = if(selected)Color(0xffFF0303) else LocalContentColor.current,
                fontSize = 10.sp)
        },
        icon = {
            LocalImage(imageResource = if(selected) screen.imageIconSelected else screen.imageIcon, size = 21.dp)
            /*Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon",
                tint = if(selected) MainYellow else Color(0xffd8d8d8)
            )*/
        },
        selected = selected,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        },
    )
}