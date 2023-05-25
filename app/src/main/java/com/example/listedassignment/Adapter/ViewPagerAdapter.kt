package com.example.listedassignment.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.listedassignment.Fragment.RecentFragment
import com.example.listedassignment.Fragment.TopLinkFragment

class ViewPagerAdapter(fragmentAdapter: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentAdapter,lifecycle){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return  when(position){
            0->TopLinkFragment()
            1-> RecentFragment()
            else -> {
                Fragment()
            }
        }
    }
}