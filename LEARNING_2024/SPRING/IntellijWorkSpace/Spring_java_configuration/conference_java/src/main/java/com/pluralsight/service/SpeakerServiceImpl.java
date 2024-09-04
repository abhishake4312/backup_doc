package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepository;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private HibernateSpeakerRepository hibernateSpeakerRepository;

    public  SpeakerServiceImpl(HibernateSpeakerRepository hibernateSpeakerRepository){
        this.hibernateSpeakerRepository=hibernateSpeakerRepository;
    }

    public void setHibernateSpeakerRepository(HibernateSpeakerRepository hibernateSpeakerRepository) {
        this.hibernateSpeakerRepository = hibernateSpeakerRepository;
    }

    public HibernateSpeakerRepository getHibernateSpeakerRepository() {
        return hibernateSpeakerRepository;
    }

    public List<Speaker> findAll(){

        return hibernateSpeakerRepository.findAll();
    }
}
