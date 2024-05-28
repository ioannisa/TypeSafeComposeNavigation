package eu.anifantakis.navdemo.navigation

import eu.anifantakis.navdemo.data.Person
import kotlinx.serialization.Serializable

sealed class NavRoute {
    @Serializable
    object MainScreen

    @Serializable
    data class DetailScreen(
        val person: Person
    )
}