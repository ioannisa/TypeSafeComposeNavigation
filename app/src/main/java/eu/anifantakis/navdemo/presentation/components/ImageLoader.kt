package eu.anifantakis.navdemo.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import eu.anifantakis.navdemo.R

@Composable
fun ImageLoader(
    imageUrl: String?,
    modifier: Modifier = Modifier,
    sizeModifier: Modifier = Modifier.size(120.dp),
    placeholder: Int = R.drawable.ic_launcher_foreground
) {
    val painter = if (imageUrl.isNullOrEmpty()) {
        painterResource(id = placeholder)
    } else {
        rememberAsyncImagePainter(imageUrl)
    }

    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier.then(sizeModifier)
    )
}