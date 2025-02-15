package com.example.techdays.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.isSpecified
import androidx.compose.ui.unit.sp

// optional
// if specified

@Composable
fun JournalTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    supportingText: String,
    height: Dp = Dp.Unspecified,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            fontSize = 17.sp,
            color = Color.Black,
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                )
            },
            supportingText = {
                Text(
                    text = supportingText,
                    fontSize = 10.sp,
                )
            },
            shape = RoundedCornerShape(8.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color(0xFF595B60),
                unfocusedContainerColor = Color.White,
                unfocusedPlaceholderColor = Color(0xFFC4C4C7),
                unfocusedSupportingTextColor = Color(0xFF87868A),
            ),
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (height.isSpecified)
                        Modifier.height(height)
                    else
                        Modifier
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JournalTextFieldPreview(modifier: Modifier = Modifier) {
    val text = remember { mutableStateOf("") }

    JournalTextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        label = "Title",
        placeholder = "Title",
        supportingText = "Required",
//        height = 200.dp,
        modifier = Modifier.fillMaxWidth()
    )
}