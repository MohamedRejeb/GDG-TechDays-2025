package com.example.techdays

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painterResource(R.drawable.cover),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(364.dp)
                .background(Color.Gray)
        )

        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        Text(
            text = "Welcome to Journal",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 22.dp)
        )


        Spacer(
            modifier = Modifier
                .weight(1f)
        )

        FeatureItem(
            text = "Write about your day and add photos, places, and more.",
            icon = R.drawable.user_rounded,
            modifier = Modifier
                .padding(horizontal = 22.dp)
        )

        Spacer(
            modifier = Modifier
                .height(32.dp)
        )

        FeatureItem(
            text = "Lock your journal to keep it private",
            icon = R.drawable.lock_svgrepo_com,
            modifier = Modifier
                .padding(horizontal = 22.dp)
        )

        Spacer(
            modifier = Modifier
                .height(32.dp)
        )

        FeatureItem(
            text = "Schedule time for writing and make it a habit.",
            icon = R.drawable.calendar_svgrepo_com,
            modifier = Modifier
                .padding(horizontal = 22.dp)
        )

        Spacer(
            modifier = Modifier
                .weight(2f)
        )

        // 0xFF + 5855D6
        Button(
            onClick = {
                
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5855D6),
                contentColor = Color.White,
            ),
            contentPadding = PaddingValues(16.dp),
            shape = RoundedCornerShape(12.dp),
            enabled = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp)
        ) {
            Text(
                text = "Continue",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }

        Spacer(
            modifier = Modifier
                .weight(1f)
        )
    }
}

@Preview(device = "spec:width=411dp,height=900dp")
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreen()
}