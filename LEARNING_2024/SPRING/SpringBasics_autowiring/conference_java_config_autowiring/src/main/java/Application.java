import com.pluralsight.repository.SpeakerRepository;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args){

        /*Below line is loading spring and loading our  configuration file into the application context. So when below line is executed
        then it will go to AppConfig and creates a registry with  our two Bean. As well as it will call both constructor of Bean.
         */
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);
        // When we do full autowiring in that case below will print after constructors are called and injected.
        System.out.println("before bean calling");
        /*Without spring
          SpeakerService speakerService = new SpeakerServiceImpl();
         */


        //When we call the speakerService Bean it will inject the speakerRepository Bean in it as well.
        SpeakerService speakerService = applicationContext.getBean("speakerService",SpeakerService.class);
        System.out.println("Service object "+speakerService);

        /*To check for scopes singleton or prototype
          When we are trying to get the Bean for second time then it will not call any no args constructor etc. It will
          directly give the instance of SERVICE injected with instance of REPO*/
        SpeakerService speakerService2 = applicationContext.getBean("speakerService",SpeakerService.class);
        System.out.println("Service object"+speakerService2);

        SpeakerRepository speakerService3 = applicationContext.getBean("speakerRepository",SpeakerRepository.class);
        System.out.println("Repo object"+speakerService3);



        System.out.println(speakerService.findAll().get(0).getFirstName());

        System.out.println("seedNum SpEL  "+ speakerService.findAll().get(0).getSeedNum());
    }
}
