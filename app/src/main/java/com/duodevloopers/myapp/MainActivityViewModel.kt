package com.duodevloopers.myapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {


    private val allPersons: LiveData<List<Person>>
    private val repository: Repository


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


}