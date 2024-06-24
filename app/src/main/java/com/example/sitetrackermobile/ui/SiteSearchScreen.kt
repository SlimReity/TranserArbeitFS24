package com.example.sitetrackermobile.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.sitetrackermobile.ui.theme.SiteTrackerMobileTheme
import com.example.sitetrackermobile.viewmodel.SharedViewModel
import com.example.sitetrackermobile.viewmodel.SiteSearchViewModel

@Composable
fun SiteSearchScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
    viewModel: SiteSearchViewModel = viewModel()
) {
    var query by remember { mutableStateOf("") }
    val searchResults by viewModel.searchResults.observeAsState(emptyList())
    val selectedTopLevelProject by sharedViewModel.selectedTopLevelProject.observeAsState("")
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Selected Top-Level Project: $selectedTopLevelProject")

        TextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Enter search query") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                if (selectedTopLevelProject.isNotEmpty()) {
                    sharedViewModel.setSearchString(query)
                    viewModel.searchSites(query, selectedTopLevelProject)
                }
            },
            modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
        ) {
            Text("Search")
        }

        LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 16.dp)) {
            items(searchResults) { site ->
                Text(text = site.name)
                Text(text = site.location)
                Divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SiteSearchScreenPreview() {
    SiteTrackerMobileTheme {
        val navController = rememberNavController()
        val sharedViewModel: SharedViewModel = viewModel()
        val siteSearchViewModel: SiteSearchViewModel = viewModel()
        SiteSearchScreen(navController, sharedViewModel, siteSearchViewModel)
    }
}
