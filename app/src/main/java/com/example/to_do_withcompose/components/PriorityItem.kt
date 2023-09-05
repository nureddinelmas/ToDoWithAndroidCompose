package com.example.to_do_withcompose.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_do_withcompose.data.models.Priority
import java.time.format.TextStyle


@Composable
fun PriorityItem(priority: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically)
    {
        Canvas(modifier = Modifier.size(16.dp)) {
            drawCircle(color = priority.color)

        }
        Box (modifier = Modifier.padding(4.dp))
        Text(
            text = priority.name,
            style = androidx.compose.ui.text.TextStyle(fontStyle = FontStyle.Italic),
            color = MaterialTheme.colors.onSurface
        )
    }
}


@Composable
@Preview
fun PriorityItemPreview() {
    PriorityItem(priority = Priority.HIGH)
}