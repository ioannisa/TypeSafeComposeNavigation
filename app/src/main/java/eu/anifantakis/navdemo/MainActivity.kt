package eu.anifantakis.navdemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.anifantakis.navdemo.presentation.screens.main.MainScreen
import eu.anifantakis.navdemo.presentation.screens.main.MainScreenViewModel
import eu.anifantakis.navdemo.ui.theme.TypeSafeComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TypeSafeComposeNavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val viewModel = viewModel<MainScreenViewModel>()

                        MainScreen(viewModel, onItemClick = { person ->
                            // when clicking an item there is no way to show the DetailScreen
                            // as we haven't setup navigation yet at all.

                            // so onItemClick, lets show a Toast about the entry clicked
                            Toast.makeText(
                                this@MainActivity,
                                "${person.name} ${person.id} - section: ${person.section}",
                                Toast.LENGTH_LONG
                            ).show()
                        })
                    }
                }
            }
        }
    }
}