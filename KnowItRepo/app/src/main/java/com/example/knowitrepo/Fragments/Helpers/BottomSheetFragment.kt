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
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import java.lang.NullPointerException

class BottomSheetFragment : BottomSheetDialogFragment(){

    private lateinit var forgotPassword: TextView
    private lateinit var signUp: TextView
    private lateinit var mainView: View
    private lateinit var mAuth: FirebaseAuth
    private var userActive = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mAuth = FirebaseAuth.getInstance()
        if(!userActive){
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

    override fun onStart() {
        super.onStart()
        var currentUser:FirebaseUser
        try {
            currentUser = mAuth.currentUser!!
            userActive = true
        } catch ( e: NullPointerException){
            Toast.makeText(context, "User not connected", Toast.LENGTH_SHORT).show()
            userActive = false
        } finally {

        }
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

