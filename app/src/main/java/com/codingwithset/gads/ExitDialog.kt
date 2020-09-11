package com.codingwithset.gads

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.codingwithset.gads.livadata.SubmissionViewModel
import com.codingwithset.gads.utils.SUBMISSION_SUCCESSFUL
import kotlinx.android.synthetic.main.dialog_layout.*


class ExitApp : DialogFragment() {
    private lateinit var submissionViewModel: SubmissionViewModel
    private var submission: Submission? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        submissionViewModel =
            ViewModelProvider(this, Injection.provideSubmissionViewModelFactory()).get(
                SubmissionViewModel::class.java
            )
        submission = arguments?.getParcelable("submission")
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = layoutInflater.inflate(R.layout.dialog_layout, container, false)
        val yes = view.findViewById<TextView>(R.id.yes)
        yes.setOnClickListener {
            submissionViewModel.submit(submission!!).data.observe(requireActivity(), {

                val inflater: LayoutInflater = layoutInflater
                val layout =
                    inflater.inflate(
                        R.layout.submission_confirmation_layout,
                        custom_toast_container
                    ) as ViewGroup
                val submissionIcon = layout.findViewById<ImageButton>(R.id.submission_icon)
                val displayMessage = layout.findViewById<TextView>(R.id.submission)
                if (it.equals(SUBMISSION_SUCCESSFUL)) {
                    displayMessage.text = it
                    submissionIcon.setBackgroundResource(R.drawable.submission_success)

                } else {
                    displayMessage.text = it
                    submissionIcon.setBackgroundResource(R.drawable.error_submission)

                }

            })


        }
        val no = view.findViewById<ImageButton>(R.id.no)
        no.setOnClickListener {
            dismiss()
        }

        return view
    }

}