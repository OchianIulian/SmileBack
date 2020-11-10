package com.example.smellitapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.smellitapp.Fragments.Content.Home;
import com.example.smellitapp.Fragments.Content.Tips;
import com.example.smellitapp.Fragments.Content.WeeksDoze;
import com.example.smellitapp.Fragments.HomeParent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.knowitrepo.R;

public class HomeActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private FragmentTransaction fragmentTransaction;
    private TextView textView;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getData();
        bottomNavigationView.setItemIconTintList(null);
        bottomNavigationView.setOnNavigationItemSelectedListener(botomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.bnv_container1, new Home()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener botomNavMethod = item -> {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.home :
                fragment = new Home();
                break;
            case R.id.week_doze :
                fragment = new WeeksDoze();
                break;
            case R.id.tips :
                fragment = new Tips();
                break;
        }
        return loadFragment(fragment);
    };

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.bnv_container1 , fragment);
            ft.commit();
            return true;
        }
        return false;
    }

    private void getData( ) {
        bottomNavigationView = findViewById(R.id.bnv);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        textView = findViewById(R.id.tv);
    }
}