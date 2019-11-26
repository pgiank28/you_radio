package com.pgiank.you_radio.view;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import com.pgiank.you_radio.model.Repositories.queryRepo;
import com.pgiank.you_radio.model.song;

public class basicView{

    public static ModelAndView getQueriesAndSetObjects(ModelAndView mvn,queryRepo repo){
        List<song> qr = repo.findAll();
        mvn.addObject("query",qr);
        return mvn;
    }
}
