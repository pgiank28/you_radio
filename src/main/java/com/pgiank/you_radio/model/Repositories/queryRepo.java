package com.pgiank.you_radio.model.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pgiank.you_radio.model.song;

public interface queryRepo extends JpaRepository<song,Integer>{

}
