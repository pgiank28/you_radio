package com.pgiank.you_radio.model.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;


@Component
public class httpRequests{

    public StringBuffer searchYoutube(String query){
        try{
            URL url = new URL("https://music.youtube.com/search?q="+query);
            URL mus = new URL (" https://www.googleapis.com/youtube/v3/videos?id=_eT42tK86p4&key=292309184354-b3kpm7h78ece9q0j1io2c30j09n9vjs4.apps.googleusercontent.com&part=snippet,contentDetails,statistics,status");
            HttpURLConnection con = (HttpURLConnection) mus.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            System.out.println(status);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content;//System.out.println(content);
        }catch(Exception e){
            System.out.println("COULDNT MAKE a proper youtube query");
            return null;
        }
    }
}
