package com.example.latihanchapter3android.model

import android.os.Parcel
import android.os.Parcelable

data class Person(val nama : String?, val usia : String?, val alamat : String?, val pekerjaan : String?) : Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        return 0;
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeString(nama)
        parcel?.writeValue(usia)
        parcel?.writeString(alamat)
        parcel?.writeString(pekerjaan)
    }

    companion object CREATOR : Parcelable.Creator<Person> {
        override fun createFromParcel(parcel: Parcel): Person {
            return Person(parcel)
        }

        override fun newArray(size: Int): Array<Person?> {
            return arrayOfNulls(size)
        }
    }
}