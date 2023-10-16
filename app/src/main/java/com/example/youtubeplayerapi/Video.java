package com.example.youtubeplayerapi;

import org.parceler.Parcel;

// Créer une classe pour représenter un élément de la RecyclerView
@Parcel
public class Video {

    public Video(){}
    // Définir les attributs d'un élément
    private String id; // L'ID de la vidéo YouTube
    private String title; // Le titre de la vidéo

    // Créer un constructeur pour initialiser les attributs
    public Video(String videoId, String videoTitle) {
        this.id = videoId;
        this.title = videoTitle;
    }

    // Créer des getters pour accéder aux attributs
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}