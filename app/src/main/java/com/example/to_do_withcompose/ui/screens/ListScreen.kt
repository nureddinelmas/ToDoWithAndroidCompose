package com.example.to_do_withcompose.ui.screens

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListScreen(navigateToListScreen: (Int) -> Unit) {
    Scaffold(
        topBar = {
            ListAppBar()
        },
        content = { },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToListScreen)
        })
}

@Composable
fun ListFab(onFabClicked: (Int) -> Unit) {
    FloatingActionButton(onClick = { onFabClicked(2) }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Button")
    }
}

@Composable
@Preview
fun ListScreenPreview() {
    ListScreen(navigateToListScreen = {})
}