package com.umairsaeed.instagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecycleStatusAdap extends RecyclerView.Adapter<RecycleStatusAdap.ViewHolder> {

    Context context;
    ArrayList<statusModel> arrayStatus;

    public RecycleStatusAdap(Context context, ArrayList<statusModel> array){
        this.context = context;
        this.arrayStatus = array;
    }

    @NonNull
    @Override
    public RecycleStatusAdap.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.status_layout, parent, false);
        RecycleStatusAdap.ViewHolder viewHolder = new RecycleStatusAdap.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleStatusAdap.ViewHolder holder, int position) {
        holder.name.setText(arrayStatus.get(position).username);
        holder.statusimg.setImageResource(arrayStatus.get(position).image);
    }

    @Override
    public int getItemCount() {
        return arrayStatus.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView statusimg;
        AppCompatTextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            statusimg = itemView.findViewById(R.id.img_status);
            name = itemView.findViewById(R.id.txt_username);
        }
    }
}
