package com.example.sitetrackermobile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _selectedTopLevelProject = MutableLiveData<String>()
    val selectedTopLevelProject: LiveData<String> get() = _selectedTopLevelProject

    private val _searchString = MutableLiveData<String>()
    val searchString: LiveData<String> get() = _searchString

    fun selectTopLevelProject(projectName: String) {
        _selectedTopLevelProject.value = projectName
    }

    fun setSearchString(search: String) {
        _searchString.value = search
    }

    fun setSelectedTopLevelProject(selectedOption: String) {

    }
}
