package com.pgiank.you_radio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class song {

     @Id
     @GeneratedValue
     public int key;
     public String artist;
     public String name;
     public String album;
     public int rank;
     public String url;
     public String videoId;

     public song(){ }
	   public song(String artist, String name,String album,int rank, String url,String videoId) {

		     this.artist = artist;
         this.name = name;
         this.album = album;
		     this.rank = rank;
		     this.url = url;
         this.videoId = videoId;
	   }


    public String toString() {
        return "song [description=" + artist +" : " + name + ", rank=" + rank;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVideoId(){
      return videoId;
    }

    public void setVideoId(String vid){
      this.videoId = vid;
    }


}
