package com.example.to_do_withcompose.data.models

import androidx.compose.ui.graphics.Color
import com.example.to_do_withcompose.ui.theme.HighPriorityColor
import com.example.to_do_withcompose.ui.theme.LowPriorityColor
import com.example.to_do_withcompose.ui.theme.MediumPriorityColor
import com.example.to_do_withcompose.ui.theme.NonePriorityColor


enum class Priority (val color: Color) {
	HIGH(HighPriorityColor),
	MEDIUM(MediumPriorityColor),
	LOW(LowPriorityColor),
	NONE(NonePriorityColor)
}