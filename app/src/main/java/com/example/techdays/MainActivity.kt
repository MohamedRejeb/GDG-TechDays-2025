package com.example.techdays

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Room
import com.example.techdays.database.NoteDatabase
import com.example.techdays.ui.theme.TechDaysTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db =
            Room.databaseBuilder(
                applicationContext,
                NoteDatabase::class.java, "note-database"
            )
                .build()

        setContent {
            NavGraph(
                getAllNotes = {
                    db.noteDao().getAll()
                },
                addNote = { note ->
                    db.noteDao().insert(note)
                },
                deleteNote = { note ->
                    db.noteDao().delete(note)
                },
            )
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .width(200.dp)
            .background(Color.Red)
            .padding(20.dp)
            .background(Color.Green)
    ) {
        Text(
            text = "Text 1"
        )

        Text(
            text = "Text 2"
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                contentAlignment = Alignment.TopEnd
            ) {
                Text(
                    text = "Text 3"
                )

                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .clip(RoundedCornerShape(4.dp))
                        .background(Color.Red)
                )
            }

            Text(
                text = "Text 4"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TechDaysTheme {
        Greeting("Android")
    }
}