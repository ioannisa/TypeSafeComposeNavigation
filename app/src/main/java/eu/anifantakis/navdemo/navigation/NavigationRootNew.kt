package eu.anifantakis.navdemo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import eu.anifantakis.navdemo.data.Person
import eu.anifantakis.navdemo.presentation.screens.detail.DetailScreen
import eu.anifantakis.navdemo.presentation.screens.main.MainScreen
import eu.anifantakis.navdemo.presentation.screens.main.MainScreenViewModel
import eu.anifantakis.navhelper.navtype.mapper
import kotlin.reflect.typeOf

@Composable
fun NavigationRootNew() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.MainScreen) {
        composable<NavRoute.MainScreen>() {
            val viewModel = viewModel<MainScreenViewModel>()
            MainScreen(viewModel, onItemClick = { person ->
                navController.navigate(NavRoute.DetailScreen(person))
            })
        }

        composable<NavRoute.DetailScreen>(
            typeMap = mapOf(typeOf<Person>() to NavType.mapper<Person>())
        ) {
            val person = it.toRoute<NavRoute.DetailScreen>().person
            DetailScreen(person, onBackPress = {
                navController.popBackStack()
            })
        }
    }
}