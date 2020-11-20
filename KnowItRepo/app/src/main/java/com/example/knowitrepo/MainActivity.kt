package com.example.knowitrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.knowitrepo.Fragments.HomeParent
import com.example.knowitrepo.Fragments.Splash

class MainActivity : AppCompatActivity() {

     var splash: Splash = Splash()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().add(R.id.container, splash).commit()

            Handler(Looper.getMainLooper()).postDelayed({
                supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.fade_in_frag, R.anim.fade_out_frag).replace(R.id.container, HomeParent()).commit()
            }, 5000)

        }

    }



}