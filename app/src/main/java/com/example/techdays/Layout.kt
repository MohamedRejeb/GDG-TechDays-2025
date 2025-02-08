package com.example.techdays

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Layout(modifier: Modifier = Modifier) {
    // Column

    // horizontalAlignment:
    // - Alignment.Start
    // - Alignment.End
    // - Alignment.CenterHorizontally

    // Row
    
    // verticalAlignment:
    // - Alignment.Top
    // - Alignment.Bottom
    // - Alignment.CenterVertically

    // Box

    // CenterVertically:
    // - Alignment.TopStart
    // - Alignment.TopCenter
    // - Alignment.TopEnd
    // - Alignment.CenterStart
    // - Alignment.Center
    // - Alignment.CenterEnd
    // - Alignment.BottomStart
    // - Alignment.BottomCenter
    // - Alignment.BottomEnd

    Column(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
    ) {
        Text(
            text = "Hello"
        )

        Text(
            text = "Hello"
        )

        Row {
            Text(
                text = "Hello"
            )

            Text(
                text = "Hello"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LayoutPrev() {
    Layout()
}