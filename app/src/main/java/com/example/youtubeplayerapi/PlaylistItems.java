package com.example.youtubeplayerapi;

import android.util.Log;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlaylistItems {

    private String msg;

    // Définir la clé API
    private static final String API_KEY = "AIzaSyAq_gZTBmHW77jpmknsGaESHoiY5iEyV0U";

    // Définir le nom du service
    private static final String APPLICATION_NAME = "com.example.youtubeplayerapi";

    // Définir le nombre maximum de résultats à renvoyer
    private static final long NUMBER_OF_VIDEOS_RETURNED = 40;

    // Créer un objet service YouTube
    private static YouTube youtube;

    private String playlistId;

    private ArrayList<Video> listOfVideos;

    public PlaylistItems(String playlistId){
        this.playlistId = playlistId;
        this.listOfVideos = retreiveVideosFromplaylist(playlistId);
    }

    public String getMsg(){
        return this.msg;
    }

    public ArrayList<Video> getListOfVideos(){
        return this.listOfVideos;
    }

    private ArrayList<Video> retreiveVideosFromplaylist(String playlistId) {
        ArrayList<Video> videoList = new ArrayList<>();
        try {
            // Initialiser l'objet service YouTube avec un HttpRequestInitializer vide
            youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName(APPLICATION_NAME).build();

            // Définir la requête à l'API YouTube Data pour récupérer les vidéos d'une playlist
            YouTube.PlaylistItems.List playlistItemsRequest = youtube.playlistItems().list(Arrays.asList("snippet", "contentDetails"));
            playlistItemsRequest.setKey(API_KEY);
            playlistItemsRequest.setPlaylistId(playlistId); // Changer l'identifiant de la playlist selon votre choix
            playlistItemsRequest.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);

            // Appeler l'API et obtenir la réponse
            PlaylistItemListResponse playlistItemsResponse = playlistItemsRequest.execute();

            // Ajouter une déclaration de journalisation ici
            Log.d("API_CALL", "La requête à l'API a été effectuée.");

            // Obtenir la liste des vidéos de la réponse
            List<PlaylistItem> playlistItems = playlistItemsResponse.getItems();

            // Afficher le titre et l'URL de chaque vidéo
            if (playlistItems != null) {
                for (PlaylistItem item : playlistItems) {
                    String title = item.getSnippet().getTitle();
                    String videoId = item.getContentDetails().getVideoId();
                    String url = "https://www.youtube.com/watch?v=" + videoId;
                    System.out.println("Titre: " + title);
                    System.out.println("URL: " + url);
                    System.out.println();
                    videoList.add(new Video(videoId, title));
                }

                this.msg = "ok";

                // Ajouter une déclaration de journalisation ici
                Log.d("API_CALL", "Les vidéos ont été ajoutées à la liste.");

            } else {
                this.msg = "Aucune vidéo trouvée.";

                // Ajouter une déclaration de journalisation ici
                Log.d("API_CALL", "Aucune vidéo n'a été trouvée.");
            }

        } catch (GoogleJsonResponseException e) {
            System.err.println("Une erreur s'est produite: " + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("Une erreur s'est produite: " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }

        return videoList;
    }

}

