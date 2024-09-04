import com.pluralsight.repository.HibernateSpeakerRepository;
import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig{

    //Here we need to wire up or inject the dependency of repository bean inside service bean so we use setter injection
    @Bean(name="speakerService")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public SpeakerService getSpeakerService(){

        // For Constructor
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl(getHibernateSpeakerService());

        // For setter
//        SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
//        speakerService.setHibernateSpeakerRepository(getHibernateSpeakerService());
        return speakerService;
    }

    @Bean(name="hibernateSpeakerRepository")
    public HibernateSpeakerRepository getHibernateSpeakerService(){
        return new HibernateSpeakerRepositoryImpl();
    }
}
