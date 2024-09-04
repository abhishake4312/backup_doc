import com.pluralsight.repository.HibernateSpeakerRepositoryImpl;
import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args){

      /*  Below line is loading spring and loading our configuration file into the application context.
         So when below line is execute then it will go and create a basic registry with 2 beans in it .*/
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

       /* Without spring

          SpeakerService speakerService = new SpeakerServiceImpl();
          */

        //When we call the speakerService Bean it will inject the speakerRepository Bean in it as well.
        SpeakerServiceImpl speakerService = applicationContext.getBean("speakerService",SpeakerServiceImpl.class);
        System.out.println(speakerService);

        SpeakerRepository hibernateSpeakerRepository= speakerService.getSpeakerRepository();

        System.out.println(hibernateSpeakerRepository);

        SpeakerRepository repo2 = applicationContext.getBean("speakerRepository",SpeakerRepository.class);
       // different object of repo as repo is prototype scope
        System.out.println(repo2);

        SpeakerService speakerService2 = applicationContext.getBean("speakerService",SpeakerService.class);
        System.out.println(speakerService2);


        System.out.println(speakerService.findAll().get(0).getFirstName());

        //create another bean of speakerservice.class with reference object name speakerService3

        SpeakerService speakerService3 = applicationContext.getBean("speakerService", SpeakerService.class);
        System.out.println(speakerService3);

        System.out.println(speakerService3.findAll().get(0).getFirstName());
    }
}
