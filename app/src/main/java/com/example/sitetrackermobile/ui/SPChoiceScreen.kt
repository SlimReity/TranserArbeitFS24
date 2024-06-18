package com.example.sitetrackermobile.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.sitetrackermobile.ui.theme.SiteTrackerMobileTheme

@Composable
fun SPChoiceScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Welcome to SPChoice Screen")
        Spacer(modifier = Modifier.height(16.dp))

        // Add other UI elements as needed
    }
}

@Preview(showBackground = true)
@Composable
fun SPChoiceScreenPreview() {
    SiteTrackerMobileTheme {
        SPChoiceScreen(rememberNavController())
    }
    Logos()
}
