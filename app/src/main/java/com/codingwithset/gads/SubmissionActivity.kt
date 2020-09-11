package com.codingwithset.gads

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.submit
import kotlinx.android.synthetic.main.activity_submission.*

class SubmissionActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission)
        submit.setOnClickListener {
            if (first_name.text.toString().isEmpty()||last_name.text.toString().isEmpty()||email_address.text.toString().isEmpty()||github_link.text.toString().isEmpty()){
                Toast.makeText(this,"Fill all fields",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val submission = Submission(first_name.text.toString(),last_name.text.toString(),email_address.text.toString(),github_link.text.toString())

            val dialog = ExitApp()
            val bundle = Bundle()
            bundle.putParcelable("submission",submission)
            dialog.arguments = bundle
            dialog.show(supportFragmentManager, "dialog")

        }
    }
}