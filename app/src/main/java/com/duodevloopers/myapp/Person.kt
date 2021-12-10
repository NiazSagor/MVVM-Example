package com.duodevloopers.myapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val age: Int
)