package com.codingwithset.gads.api

import com.codingwithset.gads.entity.Data
import com.codingwithset.gads.entity.SkillIq
import com.codingwithset.gads.utils.BASE_URL_USER
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserApi {
    /**
     * Get user details from web service
     */

    @GET(" /api/hours")
    fun LearningLeader(): Call<Data>

    @GET(" /api/skilliq")
    fun skillIqLeaders(): Call<SkillIq>

    companion object {

        fun create(): UserApi {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL_USER)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(UserApi::class.java)
        }
    }
}