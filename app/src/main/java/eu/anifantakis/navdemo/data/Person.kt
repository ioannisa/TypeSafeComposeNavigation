package eu.anifantakis.navdemo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Person(
    val id: Int,
    val section: Int,
    val name: String,
    @Serializable(with = UrlEncodedStringSerializer::class)
    val imageUrl: String,
    @Serializable(with = UrlEncodedStringSerializer::class)
    val landingPage: String
) : Parcelable
