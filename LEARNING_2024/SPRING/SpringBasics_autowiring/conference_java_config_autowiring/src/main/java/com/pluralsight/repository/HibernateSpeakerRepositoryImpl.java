package com.pluralsight.repository;

import com.pluralsight.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("speakerRepository")
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double seedNum;

    public  HibernateSpeakerRepositoryImpl(){
        System.out.println("No args constructor inside Repo");
    }
    public List<Speaker> findAll(){

        List<Speaker> speakers = new ArrayList<Speaker>();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Abhi singh");
        speaker.setLastName("Singh");
        speaker.setSeedNum(seedNum);
        speakers.add(speaker);
        return speakers;
    }

}
