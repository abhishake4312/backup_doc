import com.pluralsight.model.Speaker;
import com.pluralsight.repository.HibernateSpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ApplicationMain {

    public static void main(String[] args){

        ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

        // as service bean is prototype hence different object is fetched each time from container
        SpeakerServiceImpl speakerService = appContext.getBean("speakerService",SpeakerServiceImpl.class);

        System.out.println(speakerService);

        SpeakerServiceImpl speakerService2 = appContext.getBean("speakerService",SpeakerServiceImpl.class);

        System.out.println(speakerService2);

        System.out.println(speakerService.findAll().get(0).getFirstName());

        // As repo bean is by default singleton hence same object is returned everytime from container/app context
        System.out.println(speakerService.getHibernateSpeakerRepository());

        HibernateSpeakerRepository hibernateSpeakerRepository = appContext.getBean("hibernateSpeakerRepository",HibernateSpeakerRepository.class);

        System.out.println(hibernateSpeakerRepository);



    }
}
