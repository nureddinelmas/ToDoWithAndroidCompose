package com.example.to_do_withcompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import com.example.to_do_withcompose.ui.screens.UpdateScreen
import com.example.to_do_withcompose.util.Constants.UPDATE_SCREEN


fun NavGraphBuilder.updateComposable(

) {
    composable(
        route = UPDATE_SCREEN
    )
    {
        UpdateScreen()
    }
}

