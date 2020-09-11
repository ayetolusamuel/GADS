package com.codingwithset.gads.livadata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingwithset.gads.repository.SubmitRepository

class SubmissionViewModelFactory(private val repository: SubmitRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SubmissionViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SubmissionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
