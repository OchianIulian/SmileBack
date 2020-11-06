package com.example.smellitapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smellitapp.R;

public class Splash extends Fragment {

    private ImageView logo;
    private TextView appName;
    private Animation rotate, pulse;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        getData(view);

        startAnimation();

        return view;
    }

    private void getData(View view) {
        logo = view.findViewById(R.id.logo);
        appName = view.findViewById(R.id.name);
        appName.setVisibility(View.GONE);
        rotate = AnimationUtils.loadAnimation(getContext(), R.anim.spin);
    }

    private void startAnimation() {

        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        appName.startAnimation(anim);
        logo.startAnimation(rotate);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(1000);
                appName.setVisibility(View.VISIBLE);
                appName.startAnimation(anim);
            }
        },2300);

    }

}