package com.example.dz15room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PersonDatabase: RoomDatabase() {
    abstract fun getPersonDao():NameDao
    companion object {
        private var INSTANS: PersonDatabase? = null
        fun getDatabase (context: Context):PersonDatabase{
            return INSTANS?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonDatabase::class.java,
                    "person_database"
                ).build()
                INSTANS=instance
                instance
            }
        }
    }
}