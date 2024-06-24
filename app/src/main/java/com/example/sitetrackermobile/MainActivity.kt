package com.example.sitetrackermobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sitetrackermobile.ui.DbChoiceScreen
import com.example.sitetrackermobile.ui.LoginScreen
import com.example.sitetrackermobile.ui.SiteSearchScreen
import com.example.sitetrackermobile.ui.theme.SiteTrackerMobileTheme
import com.example.sitetrackermobile.viewmodel.SharedViewModel
import com.example.sitetrackermobile.viewmodel.SiteSearchViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiteTrackerMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val sharedViewModel = SharedViewModel()
                    val siteSearchViewModel = SiteSearchViewModel()
                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            LoginScreen(navController = navController)
                        }
                        composable(route = "dbchoice") {
                            DbChoiceScreen(
                                navController = navController,
                                context = this@MainActivity,
                                sharedViewModel = sharedViewModel
                            )
                        }
                        composable(route = "siteSearch") {
                            SiteSearchScreen(
                                navController = navController,
                                sharedViewModel = sharedViewModel,
                                viewModel = siteSearchViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}
