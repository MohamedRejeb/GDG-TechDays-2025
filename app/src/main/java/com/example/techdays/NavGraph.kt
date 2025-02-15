package com.example.techdays

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.techdays.database.NoteDao
import com.example.techdays.database.NoteEntity

val WelcomeScreenRoute = "welcome"
val JournalScreenRoute = "journal"
val AddJournalScreenRoute = "add-journal"

@Composable
fun NavGraph(
    getAllNotes: () -> List<NoteEntity>,
    deleteNote: (NoteEntity) -> Unit,
    addNote: (note: NoteEntity) -> Unit,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = WelcomeScreenRoute,
    ) {

        // Welcome Screen
        composable(WelcomeScreenRoute) {
            WelcomeScreen(
                onContinue = {
                    navController.navigate(JournalScreenRoute)
                },
            )
        }

        // Journal Screen
        composable(JournalScreenRoute) {
            JournalScreen(
                addJournal = {
                    navController.navigate(AddJournalScreenRoute)
                },
                getAllNotes = getAllNotes,
                deleteNote = deleteNote,
            )
        }

        // Add Journal Screen
        composable(AddJournalScreenRoute) {
            AddJournalScreen(
                addNote = addNote,
                navigateBack = {
                    navController.navigateUp()
                },
            )
        }

    }

}

@Preview
@Composable
fun NavGraphPreview() {
    NavGraph(
        getAllNotes = { emptyList() },
        addNote = {},
        deleteNote = {},
    )
}