package com.example.alzakwani.memorysnap.user_home;


import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.alzakwani.memorysnap.Login;
import com.example.alzakwani.memorysnap.R;

import java.util.ArrayList;

public class User_Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home);


        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment fragment= null;
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                        switch (item.getItemId()) {
                            case R.id.profile:
                              fragment = ProfileFragment.newInstance();

                                transaction.replace(R.id.frame_layout, fragment);
                                transaction.commit();
                                break;

                            case R.id.search:
                                fragment = SearchFragment.newInstance();
                                transaction.replace(R.id.frame_layout, fragment);
                                transaction.commit();
                                break;

                            case R.id.MyBook:
                                fragment = MyBookFragment.newInstance();
                                transaction.replace(R.id.frame_layout, fragment);
                                transaction.commit();
                                break;
                            case R.id.home:
                              fragment = HomeFragment.newInstance();
                                transaction.replace(R.id.frame_layout, fragment);
                                transaction.commit();
                                break;
                            case R.id.logout:
                             Intent intent=new Intent(User_Home.this,Login.class);
                             startActivity(intent);
                                break;

                        }

                        return true;
                    }
                });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, ProfileFragment.newInstance());
        transaction.commit();







    }


}
