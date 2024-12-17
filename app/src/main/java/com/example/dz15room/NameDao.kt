package com.example.dz15room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NameDao {
    @Insert
    suspend fun insert(person: Person)

    @Delete
    suspend fun delete(person: Person)

    @Query("SELECT*FROM person_table ORDER BY id ASC")
    fun getAllPerson() : List<Person>

    @Query("DELETE FROM person_table")
    fun deleteAll()
}