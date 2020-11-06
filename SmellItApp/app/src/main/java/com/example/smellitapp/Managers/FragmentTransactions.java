package com.example.smellitapp.Managers;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FragmentTransactions {

    private FragmentTransaction fragmentTransaction;
    private int container;

    public FragmentTransactions(androidx.fragment.app.FragmentTransaction fragmentTransaction, int container) {
        this.fragmentTransaction = fragmentTransaction;
        this.container = container;
    }

    public void addFragment(Fragment fragment){
      fragmentTransaction.replace(container, fragment).commit();
    }

    public void removeFragment(Fragment fragment){
        fragmentTransaction.remove(fragment).commit();
    }
}
