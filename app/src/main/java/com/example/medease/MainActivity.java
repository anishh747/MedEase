package com.example.medease;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.medease.ui.FindADoctorFragment;
import com.example.medease.ui.HomeFragment;
import com.example.medease.ui.ShopFragment;
import com.example.medease.ui.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    ChipNavigationBar chipNavigationBar;
    private Fragment fragmentInstance;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipNavigationBar = (ChipNavigationBar) findViewById(R.id.bottom_navigation);


        chipNavigationBar.setOnItemSelectedListener(item -> {
            switch (item){

                case (R.id.nav_home):
                    // getting the instance of the fragment class inside the fragment type variable
                    fragmentInstance = new HomeFragment();
                    break;

                case (R.id.nav_findADoctor):
                    fragmentInstance = new FindADoctorFragment();
                    break;

                case (R.id.nav_shop):
                    fragmentInstance = new ShopFragment();
                    break;

                case (R.id.nav_settings):
                    fragmentInstance = new SettingsFragment();
                    break;
            }

            if(fragmentInstance != null){

                /*
                * In some cases, you may see getSupportFragmentManager() being called without a reference to a FragmentActivity instance.
                * This can happen when you're calling the method from within a class that extends FragmentActivity or another class
                * that has access to a FragmentManager instance, such as a class that extends Fragment.
                    For example, if you have a class that extends FragmentActivity and you want to add a fragment to the activity,
                     you can call getSupportFragmentManager() directly within the class:
                * */
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container ,fragmentInstance).commit();
            }

        });

        //By defeault before the user presses the navigation view our home fragment should appear
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
    }
}