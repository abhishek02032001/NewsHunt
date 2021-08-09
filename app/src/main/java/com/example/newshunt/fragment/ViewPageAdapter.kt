package com.example.newshunt.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPageAdapter(fragmentmanager : FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentmanager, lifecycle) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> {
                Education()
            }
            1 -> {
                Business()
            }
            2 -> {
                Science()
            }
            3 -> {
                Sports()
            }
            4 -> {
                Technology()
            }
            else -> {
                Fragment()
            }
        }
    }
}