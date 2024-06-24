package com.example.sitetrackermobile.ui

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.Popup
import androidx.navigation.compose.rememberNavController
import com.example.sitetrackermobile.ui.theme.SiteTrackerMobileTheme
import com.example.sitetrackermobile.api.RetrofitClient
import com.example.sitetrackermobile.viewmodel.SharedViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun DbChoiceScreen(
    navController: NavHostController,
    context: Context,
    sharedViewModel: SharedViewModel
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Bitte wählen") }
    var textFieldSize by remember { mutableStateOf(IntSize.Zero) }
    var showPopup by remember { mutableStateOf(false) }
    var options by remember { mutableStateOf(listOf<String>()) }
    val scope = rememberCoroutineScope()

    // Fetch project names when the composable is launched
    LaunchedEffect(Unit) {
        scope.launch {
            try {
                val projectNames = withContext(Dispatchers.IO) {
                    RetrofitClient.topLevelProjectApi.getAllNames().execute().body() ?: emptyList()
                }
                Log.d("DbChoiceScreen", "Fetched project names: $projectNames")
                options = projectNames
            } catch (e: Exception) {
                Log.e("DbChoiceScreen", "Error fetching project names", e)
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Logos composable aligned to the top right
        Logos()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Welcome to DbChoice Screen")
            Spacer(modifier = Modifier.height(16.dp))

            // Dropdown Menu
            Box(
                modifier = Modifier
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size
                    }
            ) {
                Text(
                    text = selectedOption,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { expanded = true }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = -textFieldSize.height.toDp())  // Adjust the offset to move the dropdown menu up
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(text = option) },
                            onClick = {
                                selectedOption = option
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Button
            Button(
                onClick = {
                    if (selectedOption == "Bitte wählen") {
                        showPopup = true
                    } else {
                        sharedViewModel.setSelectedTopLevelProject(selectedOption)
                        navController.navigate("siteSearch")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Auswählen")
            }
        }

        if (showPopup) {
            Popup(
                alignment = Alignment.BottomCenter,
                onDismissRequest = { showPopup = false }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.error)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Bitte eine Auswahl treffen",
                        color = MaterialTheme.colorScheme.onError,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DbChoiceScreenPreview() {
    SiteTrackerMobileTheme {
        DbChoiceScreen(rememberNavController(), LocalContext.current, SharedViewModel())
    }
}

// Extension function to convert Int to Dp
@Composable
fun Int.toDp(): Dp = (this / androidx.compose.ui.platform.LocalDensity.current.density).dp
