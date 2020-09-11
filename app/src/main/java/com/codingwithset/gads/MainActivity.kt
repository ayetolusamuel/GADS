package com.codingwithset.gads

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.codingwithset.gads.utils.checkInternetAccess
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), TabLayout.OnTabSelectedListener {

    private var pagerAdapter: PagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .setCustomAnimations(
                    android.R.anim.fade_in,
                    android.R.anim.fade_out,
                    android.R.anim.slide_out_right,
                    android.R.anim.slide_in_left
                )
                .replace(R.id.container, LearningLeaderFragment.newInstance())
                .commitNow()
        }
        submit.setOnClickListener {
            startActivity(Intent(this, SubmissionActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }

        pagerAdapter = PagerAdapter(supportFragmentManager)
        viewpager.adapter = pagerAdapter
        tab_layout.setupWithViewPager(viewpager)
        tab_layout.addOnTabSelectedListener(this)


//      val tabStrip = tab_layout.getChildAt(-1) as LinearLayout
//       tabStrip.getChildAt(0).setOnTouchListener { v, _ -> true }
//       tabStrip.getChildAt(1).setOnTouchListener { v, _ -> true }


    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        when (tab?.position) {
            0 -> {
                supportFragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .setCustomAnimations(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out,
                        android.R.anim.slide_out_right,
                        android.R.anim.slide_in_left
                    )
                    .replace(R.id.container, LearningLeaderFragment.newInstance())
                    .commitNow()
            }

            1 -> {
                println("1 press")
                supportFragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .setCustomAnimations(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                    )
                    .replace(R.id.container, SkillIqLeaderFragment.newInstance())
                    .commitNow()
            }
        }


    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {

    }

    override fun onTabReselected(tab: TabLayout.Tab?) {

    }
}