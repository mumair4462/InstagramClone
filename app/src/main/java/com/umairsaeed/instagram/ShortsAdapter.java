package com.umairsaeed.instagram;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URL;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShortsAdapter extends RecyclerView.Adapter<ShortsAdapter.ViewHonder>{

    Context context;
    ArrayList<ShortModel> arrayShort = new ArrayList<>();

    boolean isPlay = false;

    public ShortsAdapter(Context context, ArrayList<ShortModel> arrayShort) {
        this.context = context;
        this.arrayShort = arrayShort;
    }

    @NonNull
    @Override
    public ViewHonder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.real_layout,  parent, false);

        return new ViewHonder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHonder holder, int position) {

        holder.username.setText(arrayShort.get(position).name);
        holder.userImg.setImageResource(arrayShort.get(position).userImg);

        String path = "android.resource://"+context.getPackageName()+"/raw/"+arrayShort.get(position).vadioURL;
        Uri URI = Uri.parse(path);
        holder.videoView.setVideoURI(URI);


        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlay == true){
                    holder.videoView.pause();
                    isPlay = false;
                }else {
                    holder.videoView.resume();
                }
            }
        });


        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                isPlay = true;
            }
        });

        holder.videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                isPlay = true;
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayShort.size();
    }

    public class ViewHonder extends RecyclerView.ViewHolder{

        VideoView videoView;
        CircleImageView userImg;
        AppCompatTextView username;
        public ViewHonder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.vadio_view);
            username = itemView.findViewById(R.id.username);
            userImg = itemView.findViewById(R.id.img_userimg);
        }
    }
}
