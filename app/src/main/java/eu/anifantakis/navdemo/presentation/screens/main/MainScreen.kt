package eu.anifantakis.navdemo.presentation.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import eu.anifantakis.navdemo.data.Person
import eu.anifantakis.navdemo.presentation.components.ImageLoader

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(viewModel: MainScreenViewModel, onItemClick: (Person) -> Unit) {
    val persons = viewModel.persons
    val grouped = persons.groupBy { it.section }

    LazyColumn {
        grouped.forEach { (section, sectionPersons) ->
            stickyHeader {
                Text(
                    text = "SECTION: $section",
                    color = Color.White,
                    modifier = Modifier
                        .background(color = Color.Black)
                        .padding(8.dp)
                        .fillMaxWidth()
                )
            }

            items(
                items = sectionPersons,
                key = { it.id },
                itemContent = {
                    ListItem(it, onItemClick)
                }
            )
        }
    }
}

@Composable
fun ListItem(person: Person, onItemClick: (Person) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(person)
            },
        elevation = CardDefaults.cardElevation(),
    ) {
        Row {
            ImageLoader(person.imageUrl)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                "${person.name} ${person.id}",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}