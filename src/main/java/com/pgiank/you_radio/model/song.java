package com.pgiank.you_radio.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class song {



    @Id
    public int song_id;
    public String social_media;
    public int rank;
    public String url;
    public String description;
    public int queryId;

    @PersistenceConstructor
	   public song(int song_id, String social_media, int rank, String url, String description, int queryId) {
		     this.song_id = song_id;
		     this.social_media = social_media;
		     this.rank = rank;
		     this.url = url;
		     this.description = description;
		     this.queryId = queryId;
	   }

    @Override
    public String toString() {
        return "song [description=" + description + ", queryId=" + queryId + ", rank=" + rank + ", social_media="
                + social_media + ", song_id=" + song_id + ", url=" + url + "]";
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSocial_media() {
        return social_media;
    }

    public void setSocial_media(String social_media) {
        this.social_media = social_media;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQueryId() {
        return queryId;
    }

    public void setQueryId(int queryId) {
        this.queryId = queryId;
    }



}
