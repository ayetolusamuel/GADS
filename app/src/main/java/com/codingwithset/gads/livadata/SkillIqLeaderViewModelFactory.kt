package com.codingwithset.gads.livadata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithset.gads.repository.Repository

class SkillIqLeaderViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SkillIqLeaderViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SkillIqLeaderViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
