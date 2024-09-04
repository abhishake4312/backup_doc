import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args){

        /*Here we bootstrapped our application by loading the appContext.xml. the applicationContext.xml is created inside resource folder
        so Maven when compiling will compile to our classes directory and when we run it will copy from target directory
        where class path launches from
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // SpeakerService speakerService = new SpeakerServiceImpl();
        SpeakerService speakerService = applicationContext.getBean("speakerService",SpeakerService.class);

        System.out.println(speakerService.findAll().get(0).getFirstName());
    }
}
