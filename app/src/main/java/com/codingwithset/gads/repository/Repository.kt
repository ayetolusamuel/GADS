package com.codingwithset.gads.repository

import androidx.lifecycle.MutableLiveData
import com.codingwithset.gads.entity.LearningLeaderResult
import com.codingwithset.gads.entity.SkillIQLeaderResult
import com.codingwithset.gads.api.UserApi
import com.codingwithset.gads.entity.Data
import com.codingwithset.gads.entity.SkillIq
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(private val userApi: UserApi) {


    fun getLearningLeaders(): LearningLeaderResult {
        val learningLeaderResultLiveData = MutableLiveData<Data>()
        val learningLeaderNetworkErrorLiveData = MutableLiveData<String>()

        userApi.LearningLeader().enqueue(object : Callback<Data>{
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                if (response.isSuccessful){
                    learningLeaderResultLiveData.postValue(response.body())
                }else{
                    learningLeaderNetworkErrorLiveData.postValue(response.errorBody().toString())
                }

            }

            override fun onFailure(call: Call<Data>, t: Throwable) {

            }

        })

        return LearningLeaderResult(
            learningLeaderResultLiveData,
            learningLeaderNetworkErrorLiveData
        )
    }

    fun getSkillIqLeaders(): SkillIQLeaderResult {
        val skillIqLeaderResultLiveData = MutableLiveData<SkillIq>()
        val skillIqLeaderNetworkErrorLiveData = MutableLiveData<String>()
        userApi.skillIqLeaders().enqueue(object : Callback<SkillIq>{
            override fun onResponse(call: Call<SkillIq>, response: Response<SkillIq>) {
                if (response.isSuccessful){
                    skillIqLeaderResultLiveData.postValue(response.body())
                }else{
                    skillIqLeaderNetworkErrorLiveData.postValue(response.errorBody().toString())
                }

            }

            override fun onFailure(call: Call<SkillIq>, t: Throwable) {
               skillIqLeaderNetworkErrorLiveData.postValue(t.message)
            }

        })


        return SkillIQLeaderResult(
            skillIqLeaderResultLiveData,
            skillIqLeaderNetworkErrorLiveData
        )
    }



}