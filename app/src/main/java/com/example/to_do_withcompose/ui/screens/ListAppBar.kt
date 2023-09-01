package com.example.to_do_withcompose.ui.screens

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_do_withcompose.ui.theme.topBarAppBackgroundColor
import com.example.to_do_withcompose.ui.theme.topBarAppContentColor


@Composable
fun ListAppBar() {
    DefaultListAppBar()

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Tasks", color = MaterialTheme.colors.topBarAppContentColor) },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colors.topBarAppBackgroundColor)
    )

}

@Composable
@Preview
private fun DefaultListAppBarPreview() {
    DefaultListAppBar()
}

