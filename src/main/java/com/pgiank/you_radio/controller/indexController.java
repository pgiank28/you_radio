package com.pgiank.you_radio.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import com.pgiank.you_radio.model.createRadio;
import com.pgiank.you_radio.model.song;
import com.pgiank.you_radio.model.Repositories.queryRepo;
import com.pgiank.you_radio.view.basicView;

@Controller
public class indexController{

        @Autowired
        public createRadio cr;

        @Autowired
        queryRepo repo;



        @RequestMapping("/")
        public ModelAndView basicPage(){
          ModelAndView mv = new ModelAndView();
          mv.setViewName("index");
          return mv;
        }

        @RequestMapping("/login/oauth2/code/google")
        public String firstpage(String state){
          System.out.println(state);
          return "basic";
        }

        @RequestMapping("/browse")
        public ModelAndView browsePage(){
            ModelAndView mav = new ModelAndView();
            mav = basicView.getQueriesAndSetObjects(mav,repo);
            mav.setViewName("basic");
            return mav;
        }

        @RequestMapping("/newRadio")
        public ModelAndView initRadio(@RequestParam String query){
          ModelAndView mv = new ModelAndView();

          song qr = cr.createNewRadio(query);
          repo.save(qr);

          mv.addObject("nquery",qr);

          mv = basicView.getQueriesAndSetObjects(mv,repo);
          mv.setViewName("search");
          return mv;
        }


        @RequestMapping("/radio/{radio}")
        public ModelAndView getQueries(@PathVariable int ask){
          ModelAndView mnv = new ModelAndView();
          queries qu = repo.findById(ask).orElse(new queries(null,null)); //Search for the Radio in h2 database
          //Add radio song in page
          mnv.setViewName("radio");
          return mnv;
        }
}
