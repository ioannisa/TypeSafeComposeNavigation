package eu.anifantakis.navdemo.presentation.screens.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import eu.anifantakis.navdemo.data.Person

class MainScreenViewModel : ViewModel() {
    var persons = mutableStateListOf<Person>()
        private set

    init {
        var section = 1
        for (i in 1..200) {
            if (i % 15 == 0) {
                section++
            }

            persons.add(
                Person(
                    id = i,
                    section = section,
                    name = "Ioannis Anifantakis",
                    imageUrl = "https://anifantakis.eu/wp-content/uploads/2021/05/ioannis-anifantakis-firebase-small.jpg",
                    landingPage = "https://anifantakis.eu"
                )
            )
        }
    }
}