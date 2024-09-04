import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

 /* 1) Why we create reference variable of SpeakerServiceImpl and not interface because we are calling setter method which is present
       only in class and not in interface.
    2) Here by doing this we are wiring the Bean of repo inside our service.
    3) Why we created a setter to inject instance rather than new HibernateSpeakerRepositoryImpl() because we have created
       a Bean of speakerRepository and bean is always singelton no matter how many times we call getSpeakerService and
       only one of speakerRepository will be created.
       */
    @Bean(name="speakerService")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    public SpeakerService getSpeakerService(){

       //          SETTER INJECTION

        SpeakerServiceImpl speakerServiceImpl = new SpeakerServiceImpl();
        speakerServiceImpl.setSpeakerRepository(getSpeakerRepository());


        //CONSTRUCTOR INJECTION
      //  SpeakerServiceImpl speakerServiceImpl = new SpeakerServiceImpl(getSpeakerRepository());
        return speakerServiceImpl;
    }


   /* This bean will be registered to spring application context as soon as AppConfig is initiated.
     This is a singleton,object will be created once*/
    @Bean(name="speakerRepository")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SpeakerRepository getSpeakerRepository()
    {
        return new HibernateSpeakerRepositoryImpl();
    }
}
