package com.pgiank.you_radio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ElementCollection;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import com.pgiank.you_radio.model.song;
import org.springframework.data.annotation.PersistenceConstructor;

@Entity
public class queries{

    @Id
    @GeneratedValue
    public int query_id;
    public String description;
    public String social;
    @ElementCollection
    public List<song> top10;

    queries(){}

    @PersistenceConstructor
    public queries(String des,String social){


        this.description = des;
        this.social = social;
        this.top10 = new ArrayList<song>();
    }

    public void setSong(song s){
        this.top10.add(s);
    }

    @Override
    public String toString(){
      return "Query: "+description+" \nFrom: "+social;
    }
}
