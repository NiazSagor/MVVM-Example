package com.duodevloopers.myapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {

    @Insert
    suspend fun addPerson(person:Person)

    @Query("SELECT * FROM user")
    fun getAllPersons() : LiveData<List<Person>>
}