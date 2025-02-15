package com.example.techdays

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.techdays.components.AddJournalTopBar
import com.example.techdays.components.JournalTextField
import com.example.techdays.database.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun AddJournalScreen(
    addNote: (note: NoteEntity) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val title = remember {
        mutableStateOf("")
    }

    val description = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F6F5))
    ) {
        AddJournalTopBar()

        HorizontalDivider()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(
                    horizontal = 16.dp,
                    vertical = 22.dp,
                )
        ) {
            JournalTextField(
                value = title.value,
                onValueChange = {
                    title.value = it
                },
                label = "Title",
                placeholder = "Value",
                supportingText = "Required",
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            JournalTextField(
                value = description.value,
                onValueChange = {
                    description.value = it
                },
                label = "Description",
                placeholder = "Value",
                supportingText = "Required",
                height = 200.dp,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(
                modifier = Modifier.weight(1f)
            )

            // Create scope
            val scope = rememberCoroutineScope()

            Button(
                onClick = {
                    scope.launch(Dispatchers.IO) {
                        addNote(
                            NoteEntity(
                                title = title.value,
                                description = description.value,
                            )
                        )

                        scope.launch(Dispatchers.Main) {
                            navigateBack()
                        }
                    }
                },
                contentPadding = PaddingValues(
                    horizontal = 22.dp,
                    vertical = 16.dp,
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                ),
                modifier = Modifier
            ) {
                Text(
                    text = "Save",
                    fontSize = 22.sp,
                )
            }
        }
    }

}

@Preview
@Composable
private fun AddJournalScreenPreview() {
    AddJournalScreen(
        addNote = {},
        navigateBack = {},
    )
}