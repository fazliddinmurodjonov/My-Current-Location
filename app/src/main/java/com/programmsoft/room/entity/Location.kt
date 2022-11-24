package com.programmsoft.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Location {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var longitude: Double? = null
    var latitude: Double? = null

    constructor()
    constructor(longitude: Double?, latitude: Double?) {
        this.longitude = longitude
        this.latitude = latitude
    }

}