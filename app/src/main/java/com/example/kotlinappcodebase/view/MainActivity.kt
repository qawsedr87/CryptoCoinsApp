package com.example.kotlinappcodebase.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinappcodebase.view.ui.theme.KotlinAppCodebaseTheme
import com.example.kotlinappcodebase.view.coin_details.CoinDetails
import com.example.kotlinappcodebase.view.coin_list.CoinList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAppCodebaseTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Pages.CoinList.route
                    ) {
                        composable(
                            route = Pages.CoinList.route
                        ) {
                            CoinList(navController)
                        }
                        composable(
                            route = Pages.CoinDetails.route + "/{coinId}"
                        ) {
                            CoinDetails()
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    KotlinAppCodebaseTheme {
//        Greeting("Android")
//    }
//}