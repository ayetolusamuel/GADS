package com.codingwithset.gads.livadata

import androidx.lifecycle.ViewModel
import com.codingwithset.gads.entity.SkillIQLeaderResult
import com.codingwithset.gads.repository.Repository

class SkillIqLeaderViewModel(private val repository: Repository):ViewModel() {
    fun getSkillIqLeaderList(): SkillIQLeaderResult {
        return repository.getSkillIqLeaders()
    }
}