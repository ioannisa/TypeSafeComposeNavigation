package eu.anifantakis.navdemo.navigation

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import kotlinx.serialization.Serializable
import eu.anifantakis.navdemo.data.Person
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

sealed class NavRoute {
    @Serializable
    object MainScreen

    @Serializable
    data class DetailScreen(
        val person: Person
    )
}

inline fun <reified T : Parcelable> NavType.Companion.fromCustom(): NavType<T> {
    return object : NavType<T>(
        isNullableAllowed = false
    ) {
        override fun put(bundle: Bundle, key: String, value: T) {
            bundle.putParcelable(key, value)
        }

        override fun get(bundle: Bundle, key: String): T? {
            return if (Build.VERSION.SDK_INT < 34) {
                @Suppress("DEPRECATION")
                bundle.getParcelable(key)
            } else {
                bundle.getParcelable(key, T::class.java)
            }
        }

        override fun parseValue(value: String): T {
            return Json.decodeFromString<T>(value)
        }

        override fun serializeAsValue(value: T): String {
            return Json.encodeToString(value)
        }

        override val name = T::class.java.name
    }
}