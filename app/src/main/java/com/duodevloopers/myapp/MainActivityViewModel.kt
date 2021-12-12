package com.duodevloopers.myapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    private val allPersons: LiveData<List<Person>>
    private val repository: Repository
    private val pushResponse : MutableLiveData<Response<Persons>> = MutableLiveData()


    init {
        val userDao = PersonDatabase.getDatabase(application).userDao()
        repository = Repository(userDao)
        allPersons = repository.getAllPersons()
    }

    fun addPerson(person: Person) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPerson(person)
        }
    }

    fun getAllPersons() : LiveData<List<Person>> {
        return allPersons
    }

    fun postAllPersons () {
        viewModelScope.launch {
            val persons = Persons(allPersons.value!!)
            val response : Response<Persons> = repository.postAllPersons(persons)
            pushResponse.value = response
        }
    }

    fun getPushResponse() : MutableLiveData<Response<Persons>> {
        return pushResponse
    }


}