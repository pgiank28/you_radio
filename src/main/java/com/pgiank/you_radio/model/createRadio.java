package com.pgiank.you_radio.model;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.pgiank.you_radio.model.Repositories.songRepo;
import com.pgiank.you_radio.model.http.httpRequests;

import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component("createRadio")
public class createRadio{

  @Autowired
  songRepo repo;

  @Autowired
  httpRequests hrq;

  public List<song> radioSongs(String query){
    List<song> tmp = new ArrayList<song>();
    
    return tmp;
  }

  public void findSongs(String query){
      StringBuffer sbf = hrq.searchYoutube(query);
  }
}
