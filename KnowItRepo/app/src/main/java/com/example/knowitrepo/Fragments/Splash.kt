package com.example.knowitrepo.Fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils.loadAnimation
import android.widget.ImageView
import android.widget.TextView
import com.example.knowitrepo.R


class Splash : Fragment() {

    lateinit var logo:ImageView
    lateinit var animation : Animation
    lateinit var name: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        getData(view)
        name.visibility = View.INVISIBLE
        startAnimation()
        return view
    }

    private fun getData(view: View) {
        animation = loadAnimation(context, R.anim.spin)
        logo = view.findViewById(R.id.logo)
        name = view.findViewById(R.id.name)
    }

    private fun startAnimation() {
        val alphaAnimation = AlphaAnimation(0.0f, 1.0f)
        logo.startAnimation(animation)
        Handler(Looper.getMainLooper()).postDelayed({
            alphaAnimation.duration = 1000;
            name.visibility = View.VISIBLE
            name.startAnimation(alphaAnimation)
        },3000)
    }
}