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
import com.example.sitetrackermobile.ui.theme.SiteTrackerMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiteTrackerMobileTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "login") {
                        composable(route = "login") {
                            LoginScreen(navController = navController)
                        }
                        composable(route = "dbchoice") {
                            DbChoiceScreen(navController = navController, context = this@MainActivity)
                        }
                    }
                }
            }
        }
    }
}
