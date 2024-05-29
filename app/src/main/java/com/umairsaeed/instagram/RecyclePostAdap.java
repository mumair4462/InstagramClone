package com.umairsaeed.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclePostAdap extends RecyclerView.Adapter<RecyclePostAdap.ViewHolder> {

    Context context;
    ArrayList<postModel> arrayList;

    public RecyclePostAdap(Context c, ArrayList<postModel> array){
        this.context = c;
        this.arrayList = array;
    }

    @NonNull
    @Override
    public RecyclePostAdap.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclePostAdap.ViewHolder holder, int position) {

        holder.name.setText(arrayList.get(position).name);
        holder.userpic.setImageResource(arrayList.get(position).userpic);
        holder.post.setImageResource(arrayList.get(position).postimg);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView userpic;
        AppCompatImageView post;
        AppCompatTextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userpic = itemView.findViewById(R.id.post_userpic);
            post = itemView.findViewById(R.id.post_userpost);
            name = itemView.findViewById(R.id.post_username);
        }
    }
}





















