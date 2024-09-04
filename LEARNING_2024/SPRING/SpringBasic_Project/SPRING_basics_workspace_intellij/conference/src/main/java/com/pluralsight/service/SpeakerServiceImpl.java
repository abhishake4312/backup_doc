package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements com.pluralsight.service.SpeakerService {

    //This is the painpoint where we have to manually create a object of repo class and we have hardcoded the reference of HibernateSpeakerRepositoryImpl
    // object, if we make any changes we need to rebuild the entire application .
    // We should reduce Configuration code from our application
    // cause configuration code is brittle (hard to move to diff env)
    private SpeakerRepository speakerRepository = new HibernateSpeakerRepositoryImpl();

    //Above we use interface name as a reference variable of a class object but if we have a method which is psecific to class and
    //not inside interface then we cannot use interface reference to call. We need class reference only to call such method.
    private HibernateSpeakerRepositoryImpl speakerRepository2 = new HibernateSpeakerRepositoryImpl();


    public List<Speaker> findAll(){
        // Below is a example to show that we can only use class reference to call class specific methods
        // speakerRepository2.classSpecificMethod();
        return speakerRepository.findAll();
    }
}
