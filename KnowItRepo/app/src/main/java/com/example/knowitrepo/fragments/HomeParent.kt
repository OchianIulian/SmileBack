package com.example.knowitrepo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.knowitrepo.fragments.content.Home
import com.example.knowitrepo.fragments.content.Tips
import com.example.knowitrepo.fragments.content.WeekDoze
import com.example.knowitrepo.R
import com.google.android.material.bottomnavigation.BottomNavigationView


class HomeParent : Fragment() {

    private lateinit var bottomNavigationView : BottomNavigationView
    private var home = Home()
    private var tips = Tips()
    private var weekDoze = WeekDoze()


    private val navItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.home -> {
                val transaction = fragmentManager!!
                    transaction.beginTransaction().replace(R.id.fragment_container!!, home, "Home").addToBackStack("Home").commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.week_doze -> {
                val transaction = fragmentManager!!
                    transaction.beginTransaction().replace(R.id.fragment_container!!, weekDoze, "WeekDoze").addToBackStack("WeekDoze").commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.tips -> {
                val transaction = fragmentManager!!
                    transaction.beginTransaction().replace(R.id.fragment_container!!, tips, "Tips").addToBackStack("Tips").commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_parent, container, false)
        getData(view)
        addFragments()
        bottomNavigationView.itemIconTintList = null
        bottomNavigationView.setOnNavigationItemSelectedListener(navItemSelected)
        return view;
    }

    private fun addFragments() {
        val transaction = fragmentManager!!
        transaction.beginTransaction().replace(R.id.fragment_container, home, "Home").addToBackStack("Home").commit()
    }

    private fun getData(view: View) {
        bottomNavigationView = view.findViewById(R.id.bnv)
    }

}