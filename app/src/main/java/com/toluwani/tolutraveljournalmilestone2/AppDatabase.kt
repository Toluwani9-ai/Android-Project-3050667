package com.toluwani.tolutraveljournalmilestone2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// The main Room database for the Travel Journal app.
// This class defines the list of tables used in the local database
// and provides access to the DAO layer. Room automatically generates
@Database(entities = [Trip::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // Open the Dao so my app can read and write entries
    abstract fun tripDao(): TripDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "travel_journal_db"
                ).fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}