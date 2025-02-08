package com.example.techdays

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun JournalScreen(modifier: Modifier = Modifier) {
    val journalList = remember {
        mutableStateOf(
            listOf<Journal>()
        )
    }

    val scrollState = rememberScrollState()

    Box {
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF8F4EA))
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Journal (${journalList.value.size})",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )

                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painterResource(R.drawable.user_rounded),
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                    )
                }
            }

            if (journalList.value.size == 0) {
                Text(
                    text = "List empty"
                )
            } else {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier
                        .verticalScroll(scrollState)
                ) {
                    for (journal in journalList.value) {
                        JournalItem(
                            journal = journal,
                        )
                    }
                }
            }
        }

        // Add item
        FloatingActionButton(
            onClick = {
                journalList.value =
                    journalList.value + Journal(
                        title = "Title",
                        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
                        date = "20 Jan 2025",
                    )
            },
            containerColor = Color.White,
            contentColor = Color(0xFF5755D7),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp)
        ) {
            Icon(
                Icons.Default.Add,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
        }

        val scope = rememberCoroutineScope()

        // Checking conditions?

        val visible = remember {
            mutableStateOf(false)
        }

        // listen to scroll state value
        LaunchedEffect(scrollState.value) {
            visible.value = scrollState.value > 100
        }

        AnimatedVisibility(
            visible = visible.value,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(30.dp)
        ) {
            // Scroll to top
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        scrollState.animateScrollTo(0)
                    }
                },
                containerColor = Color.White,
                contentColor = Color(0xFF5755D7),
            ) {
                Icon(
                    Icons.Default.KeyboardArrowUp,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
    }
}

@Preview(device = "spec:width=411dp,height=900dp")
@Composable
private fun JournalScreenPreview() {
    JournalScreen()
}