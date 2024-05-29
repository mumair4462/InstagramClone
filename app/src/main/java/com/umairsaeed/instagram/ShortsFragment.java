package com.umairsaeed.instagram;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umairsaeed.instagram.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class ShortsFragment extends Fragment {

//    ActivityMainBinding binding;
    Context context;

    ArrayList<ShortModel> arrayShort = new ArrayList<>();
    ShortsAdapter adapter;
    public ShortsFragment() {
        // Required empty public constructor
    }

    public ShortsFragment(Context context) {
        // Required empty public constructor
        this.context = context;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        binding = ActivityMainBinding.inflate(getLayoutInflater());



        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shorts, container, false);

        context.getTheme().applyStyle(R.style.Full_Screen_Theme, false);


        arrayShort.add(new ShortModel(R.raw.v4, "shahzad12", R.drawable.d5));
        arrayShort.add(new ShortModel(R.raw.d1, "Umair Saeed", R.drawable.d2));
        arrayShort.add(new ShortModel(R.raw.v1, "Umair Saeed", R.drawable.d2));
        arrayShort.add(new ShortModel(R.raw.d2, "Aslam", R.drawable.d3));
        arrayShort.add(new ShortModel(R.raw.d3, "Saeed123", R.drawable.d4));
        arrayShort.add(new ShortModel(R.raw.v2, "Aslam", R.drawable.d3));
        arrayShort.add(new ShortModel(R.raw.d1, "shahzad12", R.drawable.d5));
        arrayShort.add(new ShortModel(R.raw.v3, "Saeed123", R.drawable.d4));
        arrayShort.add(new ShortModel(R.raw.d5, "shahzad12", R.drawable.d5));

        adapter = new ShortsAdapter(context, arrayShort);
        ViewPager2 vp = view.findViewById(R.id.view_pager);
        vp.setAdapter(adapter);

        return view;
    }
}