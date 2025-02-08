package com.example.techdays

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextFieldSample(modifier: Modifier = Modifier) {
    Column {
        val text = remember {
            mutableStateOf("")
        }

        TextField(
            value = text.value,
            onValueChange = { newText ->
                text.value = newText
            }
        )
    }
}

@Preview
@Composable
private fun TextFieldSamplePreview() {
    TextFieldSample()
}