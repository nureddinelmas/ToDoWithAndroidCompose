package com.example.to_do_withcompose.ui.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


val Blue = Color(0xFF4660AC)

val LowPriorityColor = Color(0xFF00C980)
val MediumPriorityColor = Color(0xFFF3CC06)
val HighPriorityColor = Color(0xFFF00606)
val NonePriorityColor = Color(0xFFF6FAF8)

val Colors.topBarAppContentColor : Color
@Composable
get() = if (isLight) Color.Black else LightGray


val Colors.topBarAppBackgroundColor : Color
@Composable
get() = if (isLight) Purple80 else Black

val Colors.fabBackgroundColor : Color
@Composable
get() = if (isLight) Purple80 else Black