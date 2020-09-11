package com.codingwithset.gads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.codingwithset.gads.livadata.SubmissionViewModel
import kotlinx.android.synthetic.main.activity_main.submit
import kotlinx.android.synthetic.main.activity_submission.*

class SubmissionActivity : AppCompatActivity() {

    private lateinit var submissionViewModel: SubmissionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        submissionViewModel =
            ViewModelProvider(this, Injection.provideSubmissionViewModelFactory()).get(
                SubmissionViewModel::class.java
            )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)
        submit.setOnClickListener {
            val submission = Submission(first_name.text.toString(),last_name.text.toString(),email_address.text.toString(),github_link.text.toString())
            submissionViewModel.submit(submission).data.observe(this, {
                println("Data $it")
            })


        }
    }
}