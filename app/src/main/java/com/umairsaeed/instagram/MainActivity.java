package com.umairsaeed.instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.circularreveal.CircularRevealFrameLayout;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navbar;
    LinearLayoutCompat searchbox;
    Toolbar toolbar;
    boolean isHome = true;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        // finding all elements ids
        navbar = findViewById(R.id.navbar);
        toolbar = findViewById(R.id.toolbar);
        searchbox = findViewById(R.id.searchbox);

        // startup functions
        loadFragment(new HomeFragment(this), 1);

        navbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int ids = item.getItemId();

                isHome = false;
                if(ids == R.id.opt_home){
                    toggleToolbar(1);
                    isHome = true;
                    loadFragment(new HomeFragment(MainActivity.this), 0);
                } else if (ids == R.id.opt_search) {
                    toggleToolbar(0);
                    loadFragment(new SearchFragment(), 0);
                } else if (ids == R.id.opt_short) {
                    toggleToolbar(1);
                    loadFragment(new ShortsFragment(MainActivity.this), 0);
                } else if (ids == R.id.opt_shop) {
                    toggleToolbar(1);
                    loadFragment(new ShopFragment(), 0);
                }else if (ids == R.id.opt_user){
                    toggleToolbar(1);
                    loadFragment(new PorfileFragment(), 0);
                }


                return true;
            }
        });
    }


    public void loadFragment(Fragment fragment, int flag){
        int layoutID = R.id.fragment_container;
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(flag==1){
            ft.add(layoutID, fragment);
        }else {
            ft.replace(layoutID, fragment);
            ft.addToBackStack(null);
            if(isHome == true){

                for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                    fm.popBackStack();
                }

            }
        }

        ft.commit();
    }

    public void toggleToolbar(int flag){
        if(flag == 1){
            toolbar.setVisibility(View.VISIBLE);
            searchbox.setVisibility(View.GONE);
        }else {
            toolbar.setVisibility(View.GONE);
            searchbox.setVisibility(View.VISIBLE);
        }
    }

}