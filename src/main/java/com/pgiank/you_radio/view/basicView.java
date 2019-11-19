package com.pgiank.you_radio.view;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import com.pgiank.you_radio.model.Repositories.queryRepo;
import com.pgiank.you_radio.model.queries;

public class basicView{

    public static ModelAndView getQueriesAndSetObjects(ModelAndView mvn,queryRepo repo){
        List<queries> qr = repo.findAll();
        qr.forEach(query->{
                    System.out.println(query.description);
                  }
                    );
        return mvn;
    }
}
