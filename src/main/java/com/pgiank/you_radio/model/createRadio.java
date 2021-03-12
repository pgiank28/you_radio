package com.pgiank.you_radio.model;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.pgiank.you_radio.model.Repositories.queryRepo;
import com.pgiank.you_radio.model.http.httpRequests;

import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*Create a new radio station,based on a query */
@Component("createRadio")
public class createRadio{

  @Autowired
  queryRepo repo;

  @Autowired
  httpRequests requests;

  public List<song> createNewRadio(String query){
    List<song> ws = requests.searchYoutube(query);

    return ws;
  }
}
