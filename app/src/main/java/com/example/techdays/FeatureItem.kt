package com.example.techdays

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeatureItem(
    text: String,
    icon: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(22.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Icon(
            painterResource(icon),
            contentDescription = null,
            tint = Color(0xFF5855D6),
            modifier = Modifier
                .size(32.dp)
        )

        Text(
            text = text,
            fontSize = 18.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FeatureItemPreview1() {
    FeatureItem(
        text = "Write about your day and add photos, places, and more.",
        icon = R.drawable.user_rounded,
        modifier = Modifier
    )
}
