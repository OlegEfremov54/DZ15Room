package com.example.dz15room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "person_table")
data class Person(
    @ColumnInfo (name = "name") var name:String,
    @ColumnInfo (name= "fon") var fon:String)

{
    @PrimaryKey (autoGenerate = true)
    var id = 0

}