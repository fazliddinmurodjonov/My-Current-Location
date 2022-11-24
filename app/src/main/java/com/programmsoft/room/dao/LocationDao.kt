package com.programmsoft.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.programmsoft.room.entity.Location

@Dao
interface LocationDao {
    @Insert
    fun insert(location: Location)
    @Query("select *from Location")
    fun getAllLocations(): List<Location>
}