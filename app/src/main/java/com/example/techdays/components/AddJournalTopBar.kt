package com.example.techdays.components

import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ChevronLeft
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddJournalTopBar(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.weight(1f)
        ) {
            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Color(0xFF090909),
                ),
            ) {
                Icon(
                    Icons.Rounded.ChevronLeft,
                    contentDescription = null,
                )

                Spacer(modifier = Modifier.width(4.dp))

                // 0xFF + HEX CODE
                Text(
                    text = "Back",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal,
                )
            }
        }

        Text(
            text = "Write your note",
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
        )

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview(showBackground = true)
@Composable
private fun AddJournalTopBarPreview() {
    AddJournalTopBar()
}