package com.example.to_do_withcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.to_do_withcompose.navigation.SetupNavigation
import com.example.to_do_withcompose.ui.theme.To_Do_WithComposeTheme
import com.example.to_do_withcompose.ui.viewModels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint


/*
*CONTEXT
The Readly app has various kinds of content on offer.
* The magazine is most popular among them, but the app also recommends individual articles that it thinks the user will find interesting.
* These articles are opened in a custom reader view with various features to make the reading experience more pleasant and immersive.

The TASK
We want to add a new app feature that lets users bookmark an article to easily come back to it later.
* The user should be able to see a list of all the articles that they have bookmarked and open any of them.
*  The bookmarked articles should be kept on the device and survive the app being restarted
* but do not have to be synced to other devices or survive the app being re-installed. */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController
      val sharedViewModel: SharedViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            To_Do_WithComposeTheme {
                navController = rememberNavController()
                SetupNavigation(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )
            }
        }
    }
}
