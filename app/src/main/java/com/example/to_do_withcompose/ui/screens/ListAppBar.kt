package com.example.to_do_withcompose.ui.screens

import android.app.AlertDialog
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.IconButton
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.to_do_withcompose.R
import com.example.to_do_withcompose.components.PriorityItem
import com.example.to_do_withcompose.data.models.Priority
import com.example.to_do_withcompose.ui.theme.TOP_APP_BAR_HEIGHT
import com.example.to_do_withcompose.ui.theme.topBarAppBackgroundColor
import com.example.to_do_withcompose.ui.theme.topBarAppContentColor


@Composable
fun ListAppBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchAppBar(
        text = "Search",
        onTextChanged = {},
        onClosedClicked = {}
    ) {}

    /*DefaultListAppBar(
        onSearchClicked = onSearchClicked,
        onSortClicked = onSortClicked,
        onDeleteClicked = onDeleteClicked
    )*/

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit, onSortClicked: (Priority) -> Unit, onDeleteClicked: () -> Unit
) {

    TopAppBar(

        title = { Text(text = "TASKS", color = MaterialTheme.colors.topBarAppContentColor) },
        backgroundColor = MaterialTheme.colors.topBarAppBackgroundColor,
        windowInsets = WindowInsets(left = 3.dp, right = 5.dp, top = 5.dp),
        actions = {

            ListAppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                AlertDialog.BUTTON_NEGATIVE
            }) {
                Icon(Icons.Filled.List, contentDescription = "ADD_BUTTON")
            }
        },
    )

    /*
        CenterAlignedTopAppBar(
            actions = {

                ListAppBarActions(onSearchClicked = onSearchClicked, onSortClicked = onSortClicked, onDeleteClicked = onDeleteClicked )
            },
            navigationIcon = {
                IconButton(onClick = {
                    AlertDialog.BUTTON_NEGATIVE
                }) {
                    Icon(Icons.Filled.List, contentDescription = "ADD_BUTTON")
                }
            },

            title = { Text(text = "TASKS", color = MaterialTheme.colors.topBarAppContentColor) },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colors.topBarAppBackgroundColor),
            windowInsets = WindowInsets(left = 3.dp, right = 5.dp, top = 5.dp)
        )*/


}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchActions(onClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction(onDeleteClicked = onDeleteClicked)
}

@Composable
fun SearchActions(onClicked: () -> Unit) {
    IconButton(onClick = { /*TODO*/ }) {
        androidx.compose.material.Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search_Action",
            tint = MaterialTheme.colors.topBarAppContentColor
        )
    }
}


@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = {
        expanded = true
    }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_item),
            contentDescription = "Sort Tasks",
            tint = MaterialTheme.colors.topBarAppContentColor
        )

        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.LOW)
            }) {
                PriorityItem(priority = Priority.HIGH)
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.MEDIUM)
            }) {
                PriorityItem(priority = Priority.MEDIUM)
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.LOW)
            }) {
                PriorityItem(priority = Priority.LOW)
            }
            DropdownMenuItem(onClick = {
                expanded = false
                onSortClicked(Priority.NONE)
            }) {
                PriorityItem(priority = Priority.NONE)
            }
        }
    }
}


@Composable
fun DeleteAllAction(onDeleteClicked: () -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = {
        expanded = true
    }) {
        Icon(
            painter = painterResource(id = R.drawable.menu_vertical),
            contentDescription = stringResource(id = R.string.delete_all_items_action),
            tint = MaterialTheme.colors.topBarAppContentColor
        )

        DropdownMenu(expanded = expanded,
            onDismissRequest = {
                expanded = false
            }) {

            DropdownMenuItem(onClick = {
                expanded = false
                onDeleteClicked()
            }) {
                Text(

                    text = stringResource(id = R.string.delete_all_items_action),
                    modifier = Modifier.padding(start = 20.dp),
                    style = TextStyle(fontSize = 20.sp)
                )

                TextField(value = "dfsf", onValueChange = {

                })
            }

        }
    }
}


@Composable
fun SearchAppBar(
    text: String,
    onTextChanged: (String) -> Unit,
    onClosedClicked: () -> Unit,
    onSearchClicked: (String) -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(TOP_APP_BAR_HEIGHT),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colors.topBarAppBackgroundColor
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {
                onTextChanged(it)
            },
            placeholder = {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.disabled),
                    text = "Search",
                    color = Color.White
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colors.topBarAppContentColor,
                fontSize = MaterialTheme.typography.subtitle1.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.disabled),
                    onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search Icon",
                        tint = MaterialTheme.colors.topBarAppContentColor
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium),
                    onClick = {
                        onClosedClicked()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Close Icon",
                        tint = MaterialTheme.colors.topBarAppContentColor
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search,

                ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            ),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colors.topBarAppContentColor,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            )
        )
    }

}


@Composable
@Preview
fun SearchAppBarPreview() {
    SearchAppBar(
        text = "Search",
        onTextChanged = {},
        onClosedClicked = {}
    ) {

    }
}


@Composable
@Preview
private fun DefaultListAppBarPreview() {
    DefaultListAppBar(onSearchClicked = {}, onSortClicked = {}, onDeleteClicked = {})
}

