package com.example.youtubeplayerapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

// Créer une classe pour représenter un adaptateur personnalisé qui gère les éléments de la RecyclerView
public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    private List<Video> videoList;
    Context context;

    public VideoAdapter(ArrayList<Video> videoList, Context context) {
        this.videoList = videoList;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.video_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        Video video = videoList.get(position);

        // Bind the video data into the view holder
        holder.bind(video);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout video_item;
        ImageView imageView;
        TextView video_title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            video_item = (LinearLayout) itemView.findViewById(R.id.video_item);
            imageView = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            video_title = (TextView) itemView.findViewById(R.id.tv_title);
        }

        public void bind(final Video video) {
            video_title.setText(video.getTitle());

            video_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DetailActivity.class);
                    i.putExtra("video", Parcels.wrap(video));

                    context.startActivity(i);
                }
            });
        }

    }
}
