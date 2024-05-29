package com.umairsaeed.instagram;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView postList, statusList;
    Context context;

    ArrayList<postModel> arrayPost = new ArrayList<>();
    ArrayList<statusModel> arrayStatus = new ArrayList<>();

    public HomeFragment(Context context) {
        // Required empty public constructor
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment


        statusList = view.findViewById(R.id.recycle_status);
        statusList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        arrayStatus.add(new statusModel(R.drawable.d3, "shahzad"));
        arrayStatus.add(new statusModel(R.drawable.d1, "shahzad"));
        arrayStatus.add(new statusModel(R.drawable.d5, "shahzad"));
        arrayStatus.add(new statusModel(R.drawable.d3, "skdfj skd"));
        arrayStatus.add(new statusModel(R.drawable.d1, "dasf43"));
        arrayStatus.add(new statusModel(R.drawable.d5, "kdkad 2"));
        arrayStatus.add(new statusModel(R.drawable.d5, "kdkad 2"));
        arrayStatus.add(new statusModel(R.drawable.d5, "kdkad 2"));
        arrayStatus.add(new statusModel(R.drawable.d5, "kdkad 2"));
        arrayStatus.add(new statusModel(R.drawable.d5, "kdkad 2"));

        postList = view.findViewById(R.id.recycle_post);
        postList.setLayoutManager(new LinearLayoutManager(context));

        arrayPost.add(new postModel(R.drawable.d1,"Umair Saeed", R.drawable.p1));
        arrayPost.add(new postModel(R.drawable.d2,"Asad Saeed", R.drawable.p2));
        arrayPost.add(new postModel(R.drawable.d1,"Shahzad", R.drawable.p1));
        arrayPost.add(new postModel(R.drawable.d2,"Aslam", R.drawable.p2));
        arrayPost.add(new postModel(R.drawable.d1,"Nabeel", R.drawable.p1));
        arrayPost.add(new postModel(R.drawable.d2,"Hammad", R.drawable.p2));
        arrayPost.add(new postModel(R.drawable.d1,"Umair Saeed", R.drawable.p1));
        arrayPost.add(new postModel(R.drawable.d2,"Asad Saeed", R.drawable.p2));
        arrayPost.add(new postModel(R.drawable.d1,"Umair Saeed", R.drawable.p1));
        arrayPost.add(new postModel(R.drawable.d2,"Asad Saeed", R.drawable.p2));

        arrayPost.add(new postModel(R.drawable.d3,"Umair Saeed", R.drawable.p2));
        arrayPost.add(new postModel(R.drawable.d4,"Asad Saeed", R.drawable.p3));
        arrayPost.add(new postModel(R.drawable.d5,"Umair Saeed", R.drawable.p4));
        arrayPost.add(new postModel(R.drawable.d1,"Asad Saeed", R.drawable.p5));
        arrayPost.add(new postModel(R.drawable.d2,"Umair Saeed", R.drawable.p6));
        arrayPost.add(new postModel(R.drawable.d3,"Asad Saeed", R.drawable.p7));
        arrayPost.add(new postModel(R.drawable.d4,"Umair Saeed", R.drawable.p8));
        arrayPost.add(new postModel(R.drawable.d5,"Asad Saeed", R.drawable.p9));
        arrayPost.add(new postModel(R.drawable.d1,"Umair Saeed", R.drawable.p10));
        arrayPost.add(new postModel(R.drawable.d2,"Asad Saeed", R.drawable.p12));

        arrayPost.add(new postModel(R.drawable.d1,"Asad Saeed", R.drawable.p11));
        arrayPost.add(new postModel(R.drawable.d2,"Umair Saeed", R.drawable.p13));
        arrayPost.add(new postModel(R.drawable.d3,"Asad Saeed", R.drawable.p14));
        arrayPost.add(new postModel(R.drawable.d4,"Umair Saeed", R.drawable.p16));
        arrayPost.add(new postModel(R.drawable.d5,"Asad Saeed", R.drawable.p17));

        RecyclePostAdap adap = new RecyclePostAdap(context, arrayPost);
        postList.setAdapter(adap);

        RecycleStatusAdap statusAdapt = new RecycleStatusAdap(context, arrayStatus);
        statusList.setAdapter(statusAdapt);
        return view;
    }
}