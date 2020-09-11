package com.codingwithset.gads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithset.gads.livadata.LearningLeaderViewModel
import com.codingwithset.gads.utils.checkInternetAccess
import kotlinx.android.synthetic.main.fragment_learning_leaders.*
import kotlinx.android.synthetic.main.fragment_learning_leaders.internet_error
import kotlinx.android.synthetic.main.fragment_learning_leaders.progress_bar
import kotlinx.android.synthetic.main.fragment_learning_leaders.recyclerView
import kotlinx.android.synthetic.main.fragment_skill_leaders.*

/**
 * A placeholder fragment containing a simple view.
 */
class LearningLeaderFragment : Fragment() {

    private lateinit var learningLeaderViewModel: LearningLeaderViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_learning_leaders, container, false)


        val isFlag = requireActivity(). checkInternetAccess()
        if (!isFlag!!){
            progress_bar.visibility = View.GONE
            internet_error.visibility = View.VISIBLE
        }
        
        learningLeaderViewModel =
            ViewModelProvider(this, Injection.provideLearningLeadersViewModelFactory()).get(
                LearningLeaderViewModel::class.java
            )

        learningLeaderViewModel.getLearningLeaderList().data.observe(requireActivity(), {
            if (it.isEmpty())
                showError()
            progress_bar.visibility = View.GONE
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = UserAdapter(it)
            }
        })

        learningLeaderViewModel.getLearningLeaderList().networkErrors.observe(requireActivity(), {
            println("error $it")
        })




        return root
    }

    private fun showError() {
        progress_bar.visibility = View.GONE
    }

    companion object {
        fun newInstance() = LearningLeaderFragment()
    }

}