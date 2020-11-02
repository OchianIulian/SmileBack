package com.example.smellitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.example.smellitapp.Fragments.Home;
import com.example.smellitapp.Fragments.Splash;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Timer mTimer;
    private TimerTask mTimerTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         openSplash();

    }

    void openSplash(){

        getSupportFragmentManager().beginTransaction().add(R.id.container, new Splash()).commit();
        mTimerTask = new TimerTask() {
            @Override
            public void run() {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new Home()).commit();
            }
        };

        mTimer = new Timer();
        mTimer.schedule(mTimerTask, 10000);
    }
}