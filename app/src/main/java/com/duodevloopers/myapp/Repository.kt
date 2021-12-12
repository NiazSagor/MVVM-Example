package com.duodevloopers.myapp

import androidx.lifecycle.LiveData
import retrofit2.Response

class Repository(private val userDao: UserDao) {

    private val allPerson: LiveData<List<Person>> =
        userDao.getAllPersons()

    suspend fun addPerson(person: Person) {
        userDao.addPerson(person)
    }


    fun getAllPersons(): LiveData<List<Person>> = allPerson

    suspend fun postAllPersons(persons: Persons): Response<Persons> {
        return RetrofitInstance.api.postAllPersons(persons)
    }

}