package com.uzair.shoemate.data_source

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Shoe(
    var companyName: String = "",
    var shoeName: String = "",
    var size: String = "0",
    var description: String = ""
) :
    Parcelable {
    override fun toString(): String {
        return "$companyName | $shoeName | $size | $description"
    }
}