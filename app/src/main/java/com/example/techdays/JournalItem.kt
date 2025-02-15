package com.example.techdays

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.techdays.database.NoteEntity

@Composable
fun JournalItem(
    journal: NoteEntity,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(18.dp))
            .background(Color.White)
            .padding(
                horizontal = 16.dp,
                vertical = 11.dp,
            )
    ) {
        Text(
            text = journal.title,
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )

        Text(
            text = journal.description,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis,
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
        )

        HorizontalDivider()

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = journal.getCreatedAtFormatted(),
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
            )

            Spacer(
                modifier = Modifier
                    .weight(1f)
            )

            IconButton(
                onClick = {
                    onDelete()
                }
            ) {
                Icon(
                    Icons.Outlined.Delete,
                    contentDescription = null,
                    tint = Color(0xFFF44336),
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        }
    }
}

@Preview()
@Composable
private fun JournalItemPreview() {
    Box(
        modifier = Modifier
            .padding(20.dp)
    ) {
        val journal = NoteEntity(
            title = "Title",
            description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        )

        JournalItem(
            journal = journal,
            onDelete = {},
            modifier = Modifier
        )
    }
}