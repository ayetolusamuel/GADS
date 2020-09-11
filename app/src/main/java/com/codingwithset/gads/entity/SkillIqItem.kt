package com.codingwithset.gads.entity


import com.google.gson.annotations.SerializedName

data class SkillIqItem(
    @SerializedName("badgeUrl")
    val badgeUrl: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("score")
    val score: Int
)