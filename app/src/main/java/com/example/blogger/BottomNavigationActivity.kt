package com.example.blogger

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blogger.ui.theme.BloggerTheme

class BottomNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }


@Composable
fun BottomNavigationApp(){
    val navController = rememberNavController()
    val items = listOf(BottomNavItems.Music,BottomNavItems.Books,BottomNavItems.Movies)
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier.fillMaxSize()){
            val currentRoute = navController.currentBackStackEntry?.destination?.route
            NavHost(navController, startDestination = BottomNavItems.Music.route ){
                items.forEach{item ->
                    composable(item.route){
                        when(item){
                            is BottomNavItems.Music -> MusicScreen()
                            is BottomNavItems.Books -> BooksScreen()
                            is BottomNavItems.Movies -> MoviesScreen()
                        }
                    }
                }
            }
            BottomNavigation(
                modifier = Modifier.align(Alignment.BottomCenter),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                items.forEach {item ->
                    BottomNavigationItem(
                        icon = {Icon(painter= painterResource(id = item.icon), contentDescription = item.title)},
                        label = { Text(item.title)},
                        selected = currentRoute == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                popUpTo(navController.graph.startDestinationRoute!!) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                            },
                            alwaysShowLabel = true,
                            selectedContentColor = MaterialTheme.colors.secondary,
                            unselectedContentColor = MaterialTheme.colors.onPrimary
                            )

                    }
                }

            }
        }

    }
@Composable
fun MusicScreen(){
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Music")

    }
}

@Composable
fun BooksScreen(){
    Surface(color = MaterialTheme.colors.background ){
        Text(text = "Books")

    }
}

@Composable
fun MoviesScreen(){
    Surface(color = MaterialTheme.colors.background){
        Text(text = "Movies")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    BottomNavigationApp()
}
}




