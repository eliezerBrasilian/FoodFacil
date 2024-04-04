package com.foodfacil.graphs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.foodfacil.enums.Graph
import com.foodfacil.navigation.MainAppNavigation
import com.foodfacil.viewModel.AuthViewModel
import com.foodfacil.viewModel.UserViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RootNavigationGraph(navController: NavHostController, authViewModel: AuthViewModel,
                        userViewModel: UserViewModel,) {
    NavHost(
        navController = navController,
        route = Graph.ROOT,
        startDestination = Graph.HOME
    ) {
        authNavGraph(navController = navController, authViewModel, userViewModel)
        composable(route = Graph.HOME) {
            MainAppNavigation(authViewModel = authViewModel, userViewModel = userViewModel)
        }
    }
}