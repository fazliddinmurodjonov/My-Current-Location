package com.programmsoft.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.programmsoft.room.dao.LocationDao
import com.programmsoft.room.entity.Location

@Database(entities = [Location::class], version = 1)
abstract class LocationDB :RoomDatabase() {
    abstract fun locationDao(): LocationDao

    companion object {
        private var instance: LocationDB? = null

        @Synchronized
        fun getInstance(context: Context): LocationDB {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context,
                        LocationDB::class.java,
                        "location_db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
            }
            return instance!!
        }
    }
}