package eu.anifantakis.navdemo.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(
    val id: Int,
    val section: Int,
    val name: String,
    val imageUrl: String,
    val landingPage: String
) : Parcelable
