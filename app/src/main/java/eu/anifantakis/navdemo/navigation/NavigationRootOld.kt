package eu.anifantakis.navdemo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eu.anifantakis.navdemo.data.Person
import eu.anifantakis.navdemo.presentation.screens.detail.DetailScreen
import eu.anifantakis.navdemo.presentation.screens.main.MainScreen
import eu.anifantakis.navdemo.presentation.screens.main.MainScreenViewModel

@Composable
fun NavigationRootOld() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main_screen") {
        composable("main_screen") {
            val viewModel = viewModel<MainScreenViewModel>()
            MainScreen(viewModel, onItemClick = { person ->
                navController.currentBackStackEntry?.savedStateHandle?.set("person", person)
                navController.navigate("detail_screen")
            })
        }

        composable("detail_screen") {
            val person = navController.previousBackStackEntry?.savedStateHandle?.get<Person>("person")
            person?.let {
                DetailScreen(person, onBackPress = {
                    navController.popBackStack()
                })
            }
        }
    }
}