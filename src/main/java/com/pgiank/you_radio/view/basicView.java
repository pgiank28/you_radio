package com.pgiank.you_radio.view;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import com.pgiank.you_radio.model.Repositories.queryRepo;
import com.pgiank.you_radio.model.song;

public class basicView{

    public static ModelAndView getQueriesAndSetObjects(ModelAndView mvn,queryRepo repo,List<song> nlst){
        List<song> qr = repo.findAll();
        mvn.addObject("query",qr);

        if(nlst == null){
          return mvn;
        }else{

          for(song ns:nlst){
            repo.save(ns);
          }
          mvn.addObject("news",nlst.get(0));
          mvn.addObject("nquery",nlst);
          return mvn;
        }
    }
}
