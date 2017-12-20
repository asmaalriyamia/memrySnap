package com.example.alzakwani.memorysnap.user_home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alzakwani.memorysnap.R;



public class MyBookFragment extends Fragment {
    public static MyBookFragment newInstance() {
        MyBookFragment fragment = new MyBookFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_book, container, false);
    }
    
}
