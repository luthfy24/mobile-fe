package com.luthfy.attackontitan.Layout

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.luthfy.attackontitan.DummyData.bottomNav
import com.luthfy.attackontitan.Navigasi.Screen
import com.luthfy.attackontitan.Screens.Screen1
import com.luthfy.attackontitan.Screens.Screen2
import com.luthfy.attackontitan.Screens.AboutContent
import com.luthfy.attackontitan.Screens.detailScreen
import com.luthfy.attackontitan.ui.theme.mainGray
import com.luthfy.attackontitan.ui.theme.mainWhite

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun bottomBar() {
    val navController : NavHostController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute  =  navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
                 val title =
                     when(currentRoute){
                         Screen.Screen1.route -> "Screen 1"
                         Screen.Screen2.route -> "Screen 2"
                         Screen.Screen3.route -> "Screen 3"
                         Screen.detailScreen.route + "/{titanId}"-> "Detail Screen"
                         else -> "Not Found"
                     }
            TopAppBar(title = {
                Text(
                    text = title,
                    fontSize = 20.sp,
                    color = mainWhite
                )
            },
                navigationIcon = {
                                 if(currentRoute == Screen.detailScreen.route + "/{titanId}"){
                                     IconButton(onClick = { navController.popBackStack() }) {
                                         Icon(Icons.Filled.ArrowBack, contentDescription = null)
                                     }
                                 }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = mainGray)
            )
        },
        bottomBar = {
            if(currentRoute !in listOf(Screen.detailScreen.route + "/{titanId}"))
            NavigationBar(
                containerColor = mainGray
            ){
                val navigationItems = listOf(
                    bottomNav(
                        title = "Screen 1",
                        icon = Icons.Default.Home,
                        screen = Screen.Screen1
                    ),
                    bottomNav(
                        title = "Screen 2",
                        icon = Icons.Default.List,
                        screen = Screen.Screen2
                    ),
                    bottomNav(
                        title = "Screen 3",
                        icon = Icons.Default.Person,
                        screen = Screen.Screen3
                    )
                )
                navigationItems.forEach {
                    val selected = currentRoute == it.screen.route
                    NavigationBarItem(
                        modifier = Modifier,
                        selected = selected,
                        onClick = {
                                  navController.navigate(it.screen.route){
                                      popUpTo(navController.graph.findStartDestination().id){
                                          saveState = true
                                      }
                                      restoreState = true
                                      launchSingleTop = true
                                  }
                        },
                        icon = {
                               Icon(
                                   imageVector = it.icon,
                                   tint = mainWhite,
                                   contentDescription = it.title
                               )
                        },
                        label = {
                            Text(text = it.title,
                                color = mainWhite
                                )
                        }
                    )
                }
            }
        }
    ){
        NavHost(
            navController = navController,
            startDestination = Screen.Screen1.route,
            modifier = Modifier
                .padding(it)
            ){
            composable(Screen.Screen1.route){
                Screen1(navController)
            }
            composable(Screen.Screen2.route){
                Screen2(navController)
            }
            composable(Screen.Screen3.route){
                AboutContent()
            }
            composable(Screen.detailScreen.route + "/{titanId}",
                arguments = listOf(navArgument("titanId"){type = NavType.IntType})
                ){
                navBackStackEntry ->
                detailScreen(titanId = navBackStackEntry.arguments?.getInt("titanId")
                )
            }
        }
    }
}


@Preview
@Composable
fun view() {
    bottomBar()
}

