package com.codingwithset.gads

import androidx.lifecycle.ViewModelProvider
import com.codingwithset.gads.api.SubmissionApi
import com.codingwithset.gads.api.UserApi
import com.codingwithset.gads.livadata.LearningLeaderViewModelFactory
import com.codingwithset.gads.livadata.SkillIqLeaderViewModelFactory
import com.codingwithset.gads.livadata.SubmissionViewModelFactory
import com.codingwithset.gads.repository.Repository
import com.codingwithset.gads.repository.SubmitRepository


object Injection {
    private fun provideRepository(): Repository{
        return Repository(UserApi.create())
    }

    private fun provideSubmitRepository(): SubmitRepository{
        return SubmitRepository(SubmissionApi.create())
    }

    fun provideLearningLeadersViewModelFactory(): ViewModelProvider.Factory {
        return LearningLeaderViewModelFactory(provideRepository())
    }

    fun provideSkillIqLeadersViewModelFactory(): ViewModelProvider.Factory {
        return SkillIqLeaderViewModelFactory(provideRepository())
    }

    fun provideSubmissionViewModelFactory(): ViewModelProvider.Factory {
        return SubmissionViewModelFactory(provideSubmitRepository())
    }
}
