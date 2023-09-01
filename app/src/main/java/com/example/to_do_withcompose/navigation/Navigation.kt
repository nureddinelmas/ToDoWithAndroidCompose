package com.example.to_do_withcompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.to_do_withcompose.navigation.destinations.listComposable
import com.example.to_do_withcompose.navigation.destinations.taskComposable
import com.example.to_do_withcompose.navigation.destinations.updateComposable
import com.example.to_do_withcompose.util.Constants.LIST_SCREEN
import com.example.to_do_withcompose.util.Constants.UPDATE_SCREEN


@Composable
fun SetupNavigation(navController: NavHostController) {
    val screen = remember(navController) {
        Screens(navController = navController)

    }

    NavHost(navController = navController, startDestination = LIST_SCREEN) {

        updateComposable()


        listComposable(
            navigateToTaskScreen = screen.task
        )


        taskComposable(
            navigateToListScreen = screen.list
        )


    }
}