package com.example.mygallery

import android.net.Uri
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    var uris = mutableListOf<Uri>() // 뷰페이저가 표시할 프래그먼트 목록

    override fun getItemCount(): Int { // 표시할 프래그먼트의 개수
        return uris.size
    }

    override fun createFragment(position: Int): Fragment {  // position 위치의 프래그먼트
        return PhotoFragment.newInstance(uris[position])
    }
}