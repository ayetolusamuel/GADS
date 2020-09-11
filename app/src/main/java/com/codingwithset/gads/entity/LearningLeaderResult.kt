
package com.codingwithset.gads.entity

import androidx.lifecycle.LiveData

data class LearningLeaderResult(
    val data: LiveData<Data>,
    val networkErrors: LiveData<String>
) {

}
