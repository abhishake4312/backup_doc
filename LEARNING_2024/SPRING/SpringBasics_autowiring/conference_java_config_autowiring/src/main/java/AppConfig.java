import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
@ComponentScan({"com.pluralsight"})
public class AppConfig {

    /*Why we create reference variable of Impl because we are calling setter which is present only in class and not in interface
      Here by doing this we are wiring the Bean of repo inside our service.
      Why we created a setter to inject instance rather than new HibernateSpeakerRepositoryImpl() because we have created a Bean of
      speakerRepository and bean is always singelton no matter how many times we call getSpeakerService and only one of speakerRepository
      will be created. Hence we are calling the repo Bean and not creating direct objects,
     */

//    @Bean(name="speakerService")
//    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
//    public SpeakerService getSpeakerService(){
//
//        /*SETTER INJECTION
//         SpeakerServiceImpl speakerServiceImpl = new SpeakerServiceImpl();
//         speakerServiceImpl.setSpeakerRepository(getSpeakerRepository());
//         */
//
//        /*CONSTRUCTOR INJECTION
//          We have commented this because we will use @autowire above the constructor to implicitly inject repository instance
//          whenever service instance is created. For that we need to create a default constructor in Service class also.
//
//          SpeakerServiceImpl speakerServiceImpl = new SpeakerServiceImpl(getSpeakerRepository());
//         */
//
//        //Creating just a object of service
//        SpeakerServiceImpl speakerServiceImpl =new SpeakerServiceImpl();
//        return speakerServiceImpl;
//    }


    /*This bean will be registered to spring application context as soon as AppConfig is initiated.
      This is a singleton,object will be created once
     */
//    @Bean(name="speakerRepository")
//    @Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
//    public SpeakerRepository getSpeakerRepository()
//    {
//        return new HibernateSpeakerRepositoryImpl();
//    }
}
