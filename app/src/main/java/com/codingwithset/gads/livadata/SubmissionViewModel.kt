package com.codingwithset.gads.livadata

import androidx.lifecycle.ViewModel
import com.codingwithset.gads.Submission
import com.codingwithset.gads.entity.SubmissionResult
import com.codingwithset.gads.repository.SubmitRepository

class SubmissionViewModel(private val repository: SubmitRepository): ViewModel() {

    fun submit(submission: Submission):SubmissionResult{
        return repository.submit(submission)
    }


}