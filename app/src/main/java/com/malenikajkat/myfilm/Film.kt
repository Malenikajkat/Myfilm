package com.malenikajkat.myfilm
<<<<<<< HEAD
=======

>>>>>>> e8e86e0 (Modul_31.8 "End")
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Film(
    val title: String,
    val poster: Int,
    val description: String,
<<<<<<< HEAD
=======
    var rating: Float = 0f,
>>>>>>> e8e86e0 (Modul_31.8 "End")
    var isInFavorites: Boolean = false
) : Parcelable