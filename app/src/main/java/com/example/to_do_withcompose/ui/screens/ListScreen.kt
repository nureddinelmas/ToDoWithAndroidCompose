package com.example.to_do_withcompose.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_do_withcompose.data.models.Priority
import com.example.to_do_withcompose.ui.theme.fabBackgroundColor
import com.example.to_do_withcompose.ui.theme.topBarAppContentColor
import com.example.to_do_withcompose.ui.viewModels.SharedViewModel
import com.example.to_do_withcompose.util.SearchAppBarState


@Composable
fun ListScreen(
    navigateToListScreen: (Int) -> Unit,
    sharedViewModel: SharedViewModel

) {

    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState


    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel,
                searchAppBarState,
                searchTextState
            )
        },
        content = {},


        floatingActionButton = {
            ListFab(onFabClicked = navigateToListScreen)
        }

    )
}

@Composable
fun ListFab(onFabClicked: (Int) -> Unit) {
    FloatingActionButton(
        onClick = { onFabClicked(2) }, backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Button")
    }
}


//@Composable
//@Preview
//fun ListScreenPreview() {
//    ListScreen(navigateToListScreen = {})
//}