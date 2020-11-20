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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.layout_persistent_bottom_sheet, container, false)
        getSheetData(view)
        onClickListeners()
        return view
    }

    private fun onClickListeners() {

        forgotPassword.setOnClickListener{
            dialog!!.dismiss()
            fragmentManager!!.beginTransaction().add(R.id.container, ForgotPassword()).commit()
        }

        signUp.setOnClickListener{
            dialog!!.dismiss()
            fragmentManager!!.beginTransaction().add(R.id.container, Register()).commit()
        }
    }

    private fun getSheetData(view: View) {
        forgotPassword = view.findViewById(R.id.tvForget)
        signUp = view.findViewById(R.id.tvSignUp)
    }
}

