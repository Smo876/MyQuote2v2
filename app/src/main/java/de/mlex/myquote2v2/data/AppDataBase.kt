package de.mlex.myquote2v2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Quote::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                return Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "quotes.db"
                ).build()
            }
            return instance!!
        }
    }
}