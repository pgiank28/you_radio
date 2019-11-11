package com.pgiank.you_radio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import com.pgiank.you_radio.model.createRadio;

@Controller
public class indexController{

        @Autowired
        public createRadio cr;

        @RequestMapping("/index")
        public ModelAndView indexing(@RequestParam String query){
          ModelAndView mv = new ModelAndView();
          mv.setViewName("index");
          return mv;
        }

        @RequestMapping("/")
        public ModelAndView basicPage(){
          ModelAndView mv = new ModelAndView();
          mv.setViewName("index");
          return mv;
        }

        @RequestMapping("/newRadio")
        public ModelAndView initRadio(@RequestParam String query){
          ModelAndView mv = new ModelAndView();
          cr.findSongs(query);
          mv.setViewName("index");
          return mv;
        }
}
