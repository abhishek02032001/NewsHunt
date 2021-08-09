package com.example.newshunt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.newshunt.fragment.*
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_NewsHunt)
        setContentView(R.layout.activity_main)

        val adapter = ViewPageAdapter(supportFragmentManager, lifecycle)
        viewPage.adapter = adapter

        setTabBar()
    }


    private fun setTabBar() {
        TabLayoutMediator(tabBar, viewPage) {tab, position ->
            when(position) {
                0 -> {
                    tab.text = "General"
                }
                1 -> {
                    tab.text = "Business"
                }
                2 -> {
                    tab.text = "Science"
                }
                3 -> {
                    tab.text = "Sports"
                }
                4 -> {
                    tab.text = "Technology"
                }
            }
        }.attach()
    }
}