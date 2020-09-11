package com.codingwithset.gads.repository

import androidx.lifecycle.MutableLiveData
import com.codingwithset.gads.Submission
import com.codingwithset.gads.api.SubmissionApi
import com.codingwithset.gads.entity.SubmissionResult
import com.codingwithset.gads.utils.SUBMISSION_NOT_SUCCESSFUL
import com.codingwithset.gads.utils.SUBMISSION_SUCCESSFUL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SubmitRepository(private val submissionApi: SubmissionApi) {


    fun submit(submission: Submission):SubmissionResult{
       val submissionLiveData = MutableLiveData<String>()
        submissionApi.dataSubmission(submission.name!!,submission.lastName!!,submission.emailAddress!!,submission.linkToProject!!).enqueue(object : Callback<Void>{
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                submissionLiveData.postValue(SUBMISSION_SUCCESSFUL)
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
              submissionLiveData.postValue(SUBMISSION_NOT_SUCCESSFUL)
            }

        })
        return SubmissionResult(submissionLiveData)
    }

}