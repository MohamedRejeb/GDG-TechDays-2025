package com.example.techdays

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun ComposeStates() {
    val counter = remember {
        mutableStateOf(0)
    }

    val isTimerOn = remember {
        mutableStateOf(false)
    }

    LaunchedEffect(isTimerOn.value) {
        if (isTimerOn.value) {
            // Start

            while (true) {
                delay(100)
                counter.value = counter.value + 1
            }
        } else {
            // Stop
            counter.value = 0
        }
    }

    Column(
//        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .padding(20.dp)
            .background(Color.White)
    ) {
        Text(
            text = "Counter: ${counter.value}"
        )

        Row {
            Button(
                onClick = {
                    isTimerOn.value = true
                }
            ) {
                Text(
                    text = "Start"
                )
            }

            Button(
                onClick = {
                    isTimerOn.value = false
                }
            ) {
                Text(
                    text = "Stop"
                )
            }
        }
    }

}

@Preview
@Composable
private fun ComposeStatesPreview() {
    ComposeStates()
}

// navController.navigate("details")
