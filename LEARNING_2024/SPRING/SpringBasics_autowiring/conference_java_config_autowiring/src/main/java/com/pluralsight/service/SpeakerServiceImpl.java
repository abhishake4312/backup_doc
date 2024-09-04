package com.pluralsight.service;

import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
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
        System.out.println("No args constructor inside service");
    };

    /* We can inject or wire the repo instance into service instance
       either by using setter or constructor approach
     */

    // CONSTRUCTOR APPROACH

    @Autowired
    public SpeakerServiceImpl(SpeakerRepository speakerRepository){
        System.out.println("This is the parameter service constructor");
        this.speakerRepository=speakerRepository;
        System.out.println("Injection of repo into service happens here "+this.speakerRepository);
    }

/*    @PostConstruct
    private void initialize(){
        System.out.println("This will be called after beans are created/constructors are called and injected");
    }*/

    //SETTER APPROACH
  //  @Autowired
    public void setSpeakerRepository(SpeakerRepository speakerRepository) {
        System.out.println("This is a setter");
        System.out.println("REPO object inside setter "+speakerRepository);
        this.speakerRepository = speakerRepository;
    }

    public List<Speaker> findAll(){
        return speakerRepository.findAll();
    }
}
