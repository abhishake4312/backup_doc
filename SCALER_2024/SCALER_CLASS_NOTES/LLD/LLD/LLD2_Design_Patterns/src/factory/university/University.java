package factory.university;

public class University {
    public static void main(String[] args) {
        Student s=new CommerceStudent();

        if(s instanceof ScienceStudent){
            Course c=new MathsCourse();
            c.enroll();
        }else if(s instanceof CommerceStudent){
            Course c=new EconomicsCourse();
            c.enroll();
        }
    }
}
