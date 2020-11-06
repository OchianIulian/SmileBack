package com.example.smellitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.example.smellitapp.Fragments.Home;
import com.example.smellitapp.Fragments.Splash;
import com.example.smellitapp.Managers.FragmentTransactions;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private FragmentTransactions fragmentTransactions;
    private Timer mTimer;
    private TimerTask mTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData();
        getOverSplash();

    }

    private void getData(){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransactions = new FragmentTransactions( fragmentTransaction, R.id.container);
    }

    private void getOverSplash(){

        fragmentTransactions.addFragment(new Splash());
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fade_in_frag, R.anim.fade_out_frag).replace(R.id.container, new Home()).commit();
                //fragmentTransaction.add(R.id.container, new Home());
                //fragmentTransactions.addFragment(new Home());
            }
        };

        mTimer = new Timer();
        mTimer.schedule(mTimerTask, 5000);
    }
}