package com.example.knowitrepo.fragments.content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import com.example.knowitrepo.fragments.helpers.BottomSheetFragment
import com.example.knowitrepo.fragments.helpers.DoubleClickListener
import com.example.knowitrepo.R


class Home : Fragment() {

    private lateinit var doubleTab: FrameLayout
    private lateinit var bottomSheetFragment: BottomSheetFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        getData(view)
        doubleTapFunc(view)

        return view;
    }

    private fun getData(view: View) {
        bottomSheetFragment = BottomSheetFragment()
    }


    private fun doubleTapFunc(view: View) {
        doubleTab = view.findViewById(R.id.doubleTab)
        doubleTab.setOnClickListener(object : DoubleClickListener() {
            override fun onDoubleClick(v: View?) {
                if(!bottomSheetFragment.isAdded) {
                    bottomSheetFragment.show(fragmentManager!!, "BottomSheetDialog")
                } else {
                    Toast.makeText(context, "Calm down bro, tap slowlier!", Toast.LENGTH_SHORT).show()
                    return
                }
            }
        })
    }

}