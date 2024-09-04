package com.pluralsight.repository;

import com.pluralsight.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements HibernateSpeakerRepository {

    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers  = new ArrayList<Speaker>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("abhi");
        speaker.setLastName("singh");

        speakers.add(speaker);

        return speakers;
    }
}
