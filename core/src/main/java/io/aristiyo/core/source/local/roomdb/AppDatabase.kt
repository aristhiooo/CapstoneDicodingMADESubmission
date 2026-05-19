package io.aristiyo.core.source.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import io.aristiyo.core.source.local.entity.TeamEntity

@Database(entities = [TeamEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun teamDao(): TeamDao
}