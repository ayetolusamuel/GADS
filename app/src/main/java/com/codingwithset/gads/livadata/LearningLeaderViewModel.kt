package com.codingwithset.gads.livadata

import androidx.lifecycle.ViewModel
import com.codingwithset.gads.entity.LearningLeaderResult
import com.codingwithset.gads.repository.Repository

class LearningLeaderViewModel(private val repository: Repository): ViewModel() {

    fun getLearningLeaderList(): LearningLeaderResult {
        return repository.getLearningLeaders()
    }


}