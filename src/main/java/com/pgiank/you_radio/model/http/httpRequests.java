package com.pgiank.you_radio.model.http;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.YouTubeRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpRequest;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.SearchResultSnippet;
import com.google.api.services.youtube.model.ResourceId;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.pgiank.you_radio.model.song;
import com.pgiank.you_radio.model.http.videoToSongConverter;

@Component
public class httpRequests{

    @Autowired
    videoToSongConverter vsc;


    public List<song> searchYoutube(String query){
        try{
          YouTube youtube = new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), new GsonFactory(), new HttpRequestInitializer() {
              public void initialize(HttpRequest request) throws IOException {
              }
            }).setApplicationName("Youtube-radio")
            .setYouTubeRequestInitializer
            (new YouTubeRequestInitializer("AIzaSyDifL5Wh5oF4h-cmAFaTzicMl43X4I4K24")).build();

            YouTube.Search.List sr = youtube.search().list("id,snippet");
            sr.setQ(query);
            sr.setType("video");
            sr.setMaxResults(new Long(3));

            SearchListResponse searchResponse = sr.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();

            List<song> h=new ArrayList<song>();
            if (searchResultList != null) {

              for(SearchResult res:searchResultList){
                SearchResultSnippet sn = res.getSnippet();

                h.add(vsc.youtubeSongs(sn.getTitle(),res));
                System.out.println(res.getId().getVideoId());
              }
              return h;
            }else{
              return null;
            }

        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
