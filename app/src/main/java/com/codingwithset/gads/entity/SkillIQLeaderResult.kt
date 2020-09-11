
package com.codingwithset.gads.entity

import androidx.lifecycle.LiveData

data class SkillIQLeaderResult(
    val data: LiveData<SkillIq>,
    val networkErrors: LiveData<String>
) {

}
