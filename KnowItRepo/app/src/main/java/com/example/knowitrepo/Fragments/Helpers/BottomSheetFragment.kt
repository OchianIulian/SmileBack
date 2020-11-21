package com.example.knowitrepo.Fragments.Helpers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.knowitrepo.Fragments.Register.ForgotPassword
import com.example.knowitrepo.Fragments.Register.Register
import com.example.knowitrepo.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment(){

    private lateinit var forgotPassword: TextView
    private lateinit var signUp: TextView
    private lateinit var mainView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var ok =1
        if(ok==1){
            //TODO: log in
            mainView = inflater.inflate(R.layout.layout_persistent_bottom_sheet, container, false)
            getSheetData1(mainView)
            onClickListeners1()
        } else {
            //TODO: open profile, make sugestions, share
            mainView = inflater.inflate(R.layout.layout_persistent_bottom_sheet_logged_in, container, false)
        }

        return mainView
    }

    private fun onClickListeners1() {

        forgotPassword.setOnClickListener{
            dialog!!.dismiss()
            fragmentManager!!.beginTransaction().add(R.id.container, ForgotPassword()).commit()
        }

        signUp.setOnClickListener{
            dialog!!.dismiss()
            fragmentManager!!.beginTransaction().add(R.id.container, Register()).commit()
        }
    }

    private fun getSheetData1(view: View) {
        forgotPassword = view.findViewById(R.id.tvForget)
        signUp = view.findViewById(R.id.tvSignUp)
    }
}

