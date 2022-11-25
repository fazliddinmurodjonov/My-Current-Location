package com.programmsoft.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Location {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var latitude: Double? = null

    var longitude: Double? = null

    constructor()
    constructor( latitude: Double?,longitude: Double?) {
        this.latitude = latitude
        this.longitude = longitude
    }

}