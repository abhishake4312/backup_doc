package factory.university;

public class EconomicsCourse implements Course{
    @Override
    public void enroll() {
        System.out.println("Enrolling Economics");
    }
}
