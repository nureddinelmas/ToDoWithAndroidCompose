package com.example.to_do_withcompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_do_withcompose.ui.screens.ListScreen
import com.example.to_do_withcompose.ui.viewModels.SharedViewModel
import com.example.to_do_withcompose.util.Constants.LIST_ARGUMENT_KEY
import com.example.to_do_withcompose.util.Constants.LIST_SCREEN


fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigateToListScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}