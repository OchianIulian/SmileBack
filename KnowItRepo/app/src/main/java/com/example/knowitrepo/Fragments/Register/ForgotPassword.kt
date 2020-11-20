package com.example.knowitrepo.Fragments.Register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.knowitrepo.R

class ForgotPassword : Fragment() {

    lateinit var goBack: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_forgot_password, container, false)

        getData(view)
        goBack.setOnClickListener{
            //if(fragmentManager!!.backStackEntryCount > 0){
                //fragmentManager!!.popBackStack()
           // } else {
            //    activity!!.onBackPressed()
           // }
            fragmentManager!!.beginTransaction().remove(this).commit()
        }
        return view
    }

    private fun getData(view: View) {
        goBack = view.findViewById(R.id.btn_go_back)
    }

}