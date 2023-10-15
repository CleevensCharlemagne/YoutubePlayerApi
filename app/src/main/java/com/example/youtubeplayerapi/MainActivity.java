package com.example.youtubeplayerapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_video  = findViewById(R.id.rv_video);
        rv_video.setLayoutManager(new LinearLayoutManager(this));
        rv_video.setHasFixedSize(true);
    }
}