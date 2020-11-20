package com.example.knowitrepo.Fragments.Content

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.knowitrepo.Fragments.Helpers.BottomSheetFragment
import com.example.knowitrepo.Fragments.Helpers.DoubleClickListener
import com.example.knowitrepo.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


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
                Toast.makeText(context, "Open profile/suggestion box", Toast.LENGTH_SHORT).show()
                bottomSheetFragment.show(fragmentManager!!, "BottomSheetDialog")
            }
        })
    }

}