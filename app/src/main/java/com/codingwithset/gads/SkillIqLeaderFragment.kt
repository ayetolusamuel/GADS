package com.codingwithset.gads

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.codingwithset.gads.livadata.SkillIqLeaderViewModel
import com.codingwithset.gads.utils.checkInternetAccess
import com.github.ybq.android.spinkit.SpinKitView
import kotlinx.android.synthetic.main.fragment_skill_leaders.*

/**
 * A placeholder fragment containing a simple view.
 */
class SkillIqLeaderFragment : Fragment() {

    private lateinit var skillIqLeaderViewModel: SkillIqLeaderViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_skill_leaders, container, false)

        val isFlag = requireActivity(). checkInternetAccess()
        if (!isFlag!!){
            val progressBar = root.findViewById<SpinKitView>(R.id.progress_bar)
            progressBar.visibility = View.GONE
            val internetError = root.findViewById<TextView>(R.id.internet_error)
            internetError.visibility = View.VISIBLE
        }

        skillIqLeaderViewModel =
            ViewModelProvider(this, Injection.provideSkillIqLeadersViewModelFactory()).get(
                SkillIqLeaderViewModel::class.java
            )

        skillIqLeaderViewModel.getSkillIqLeaderList().data.observe(requireActivity(), {
            if (it.isEmpty())
                showError()
           requireActivity().runOnUiThread {
               progress_bar.visibility = View.GONE
               recyclerView.apply {
                   layoutManager = LinearLayoutManager(requireActivity())
                   adapter = SkillAdapter(it)
               }
           }
        })

        skillIqLeaderViewModel.getSkillIqLeaderList().networkErrors.observe(requireActivity(), {
            println("Error $it")

        })



        return root
    }

    private fun showError() {
        requireActivity().runOnUiThread {
            progress_bar.visibility = View.GONE
        }

    }

    companion object {
        fun newInstance() = SkillIqLeaderFragment()
    }
}