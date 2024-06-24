package com.example.sitetrackermobile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

data class Site(val name: String, val location: String)

class SiteSearchViewModel : ViewModel() {
    private val _searchResults = MutableLiveData<List<Site>>()
    val searchResults: LiveData<List<Site>> get() = _searchResults

    fun searchSites(query: String, projectName: String) {
        viewModelScope.launch {
            // Replace this with your actual data fetching logic
            _searchResults.value = fetchSites(query, projectName)
        }
    }

    private suspend fun fetchSites(query: String, projectName: String): List<Site> {
        // Simulate a network call or database query
        // Replace with actual implementation
        return listOf(
            Site(name = "com.example.sitetrackermobile.ui.Site 1", location = "Location 1"),
            Site(name = "com.example.sitetrackermobile.ui.Site 2", location = "Location 2")
        )
    }
}
