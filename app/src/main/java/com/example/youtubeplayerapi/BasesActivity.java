package com.example.youtubeplayerapi;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bases);

        PlaylistItems playlistItems = new PlaylistItems("PLeP9l-5A3htPeGQNa3FxjWMiqz3rXtdlH");

        // Créer une liste d'éléments vidéo
        ArrayList<Video> videoItems = playlistItems.getListOfVideos();

        // Créer un adaptateur pour la RecyclerView
        VideoAdapter videoAdapter = new VideoAdapter(videoItems, this);

        // Obtenir la RecyclerView du layout de l'activité
        RecyclerView recyclerView = findViewById(R.id.rv_bases);

        // Définir le gestionnaire de layout pour la RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Définir l'adaptateur pour la RecyclerView
        recyclerView.setAdapter(videoAdapter);



        Toast.makeText(this, playlistItems.getMsg(), Toast.LENGTH_SHORT).show();
    }
}