package com.codingwithset.gads.livadata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithset.gads.repository.Repository

class LearningLeaderViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LearningLeaderViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LearningLeaderViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
