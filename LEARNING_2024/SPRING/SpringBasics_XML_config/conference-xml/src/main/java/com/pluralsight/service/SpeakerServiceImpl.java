package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements com.pluralsight.service.SpeakerService {

    /* Below code is the pain point where we have to manually create a object of repo class and we have hardcoded the reference of
        HibernateSpeakerRepositoryImpl object, if we make any changes we need to rebuild the entire application .
        We should reduce Configuration code from our application
        cause configuration code is brittle (hard to move to diff env)
        Now here we remove the hardcoded object creation and will create a setter of repo.


        private SpeakerRepository speakerRepository = new HibernateSpeakerRepositoryImpl();
      */
    private SpeakerRepository speakerRepository;

  public SpeakerServiceImpl(){
}

    //Even if we have other 1 args constructor the aapContext can find the appropraite consstuctor for injection
    public SpeakerServiceImpl(int a){
        System.out.println("this is also a 1 args constructor");
    }
    //Constructor injection
    public SpeakerServiceImpl(SpeakerRepository speakerRepository){
        this.speakerRepository=speakerRepository;
    }

    //important to use setSpeakerRepository cause in xml the propertyname is speakerRepository
    //when we do autowire byType then name of setter is not required but when we do byName then name of the setter is important
    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    public List<Speaker> findAll(){
        // Below is a example to show that we can only use class reference to call class specific methods
        // speakerRepository2.classSpecificMethod();
        return speakerRepository.findAll();
    }
}
