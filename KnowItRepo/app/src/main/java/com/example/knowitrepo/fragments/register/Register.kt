package com.example.knowitrepo.fragments.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.knowitrepo.R


class Register : Fragment() {

    private lateinit var goBack:Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        getData(view)

        goBack.setOnClickListener{
            fragmentManager!!.beginTransaction().remove(this).commit()
        }

        return view
    }

    private fun getData(view: View) {
        goBack = view.findViewById(R.id.btn_go_back)
    }
}