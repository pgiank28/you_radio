package com.pgiank.you_radio.model;

import com.pgiank.you_radio.model.Repositories.queryRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class fetchSongs{

  @Autowired queryRepo repo;

  public static song find(){
    song mys = new song(1,"facebook",1,"url","description",12);

    return mys;
  }
}
