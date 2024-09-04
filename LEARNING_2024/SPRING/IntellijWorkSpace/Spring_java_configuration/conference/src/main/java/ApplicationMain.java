import com.pluralsight.model.Speaker;
import com.pluralsight.service.SpeakerService;
import com.pluralsight.service.SpeakerServiceImpl;

import java.util.List;

public class ApplicationMain {

    public static void main(String[] args){
        SpeakerService speakerService=new SpeakerServiceImpl();
        List<Speaker> speakerList=speakerService.findAll();
        for(Speaker speaker:speakerList){
            System.out.println(speaker.getFirstName()+" "+speaker.getLastName());
        }
    }
}
