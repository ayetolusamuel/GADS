package com.codingwithset.gads

import android.os.Parcel
import android.os.Parcelable

data class Submission(
    val emailAddress: String?,
    val name: String?,
    val lastName: String?,
    val linkToProject: String?
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(emailAddress)
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeString(linkToProject)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Submission> {
        override fun createFromParcel(parcel: Parcel): Submission {
            return Submission(parcel)
        }

        override fun newArray(size: Int): Array<Submission?> {
            return arrayOfNulls(size)
        }
    }

}