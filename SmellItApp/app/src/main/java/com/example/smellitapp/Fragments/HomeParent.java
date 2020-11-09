package com.example.smellitapp.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.smellitapp.Fragments.Content.Home;
import com.example.smellitapp.Fragments.Content.Tips;
import com.example.smellitapp.Fragments.Content.WeeksDoze;
import com.example.smellitapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeParent extends Fragment {

    BottomNavigationView bottomNavigationView;

    private final Home homeFragment = new Home();
    private final Tips tipsFragment = new Tips();
    private  final WeeksDoze weeksDozeFragment = new WeeksDoze();
    private FragmentTransaction fragmentTransaction;
    Fragment active = homeFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        getData(view);
        bottomNavigationView.setItemIconTintList(null);
        setFragments();
        return  view;
    }

    private void setFragments() {

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment fragment;
            switch (item.getItemId()){
                case R.id.home:
                    fragment = new Home();
                    break;
                case R.id.week_doze:
                    fragment = new WeeksDoze();
                    break;
                case R.id.tips:
                    fragment = new Tips();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + item.getItemId());
            }
            //fragmentTransaction.add(R.id.bnv_container, fragment).commit();
            return true;
        });

    }

    private void getData(View view) {
        bottomNavigationView = view.findViewById(R.id.bnv);
        fragmentTransaction = getFragmentManager().beginTransaction();
    }
}