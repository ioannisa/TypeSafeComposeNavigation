package eu.anifantakis.navdemo.presentation.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eu.anifantakis.navdemo.data.Person
import eu.anifantakis.navdemo.presentation.components.ImageLoader

@Composable
fun DetailScreen(person: Person, onBackPress: () -> Unit) {
    Card(
        modifier = Modifier.padding(12.dp),
        elevation = CardDefaults.cardElevation(),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text("section ${person.section}", style = MaterialTheme.typography.headlineMedium)
            Text("${person.name} ${person.id}", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(8.dp))
            ImageLoader(person.imageUrl, sizeModifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { onBackPress() }) {
                Text("Go Back")
            }
        }
    }
}