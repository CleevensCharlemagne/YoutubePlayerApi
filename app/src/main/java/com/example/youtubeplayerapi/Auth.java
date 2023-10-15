package com.example.youtubeplayerapi;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

public class Auth {
    // Transport HTTP
    public static final com.google.api.client.http.HttpTransport HTTP_TRANSPORT = createTrustedTransport();
    // Fabrique JSON
    public static final com.google.api.client.json.JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    private static com.google.api.client.http.HttpTransport createTrustedTransport() {
        try {
            return GoogleNetHttpTransport.newTrustedTransport();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
