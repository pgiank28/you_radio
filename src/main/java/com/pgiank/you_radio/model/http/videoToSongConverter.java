package com.pgiank.you_radio.model.http;

import org.springframework.stereotype.Component;
import com.pgiank.you_radio.model.song;
import com.google.api.services.youtube.model.SearchResult;

@Component
public class videoToSongConverter{

  public song youtubeSongs(String dirtyVid,SearchResult res){
    dirtyVid = dirtyVid.replaceAll("Official Video","");
    dirtyVid = dirtyVid.replaceAll("Official Music Video","");
    dirtyVid = dirtyVid.replaceAll("Lyric Video","");
    String[] pts = dirtyVid.split("-");

    song ns = new song(pts[0].replaceAll("\\p{P}",""),pts[1].replaceAll("\\p{P}",""),dirtyVid,1,"https://www.youtube.com/embed/"+res.getId().getVideoId()+"?rel=0");
    return ns;
  }
}