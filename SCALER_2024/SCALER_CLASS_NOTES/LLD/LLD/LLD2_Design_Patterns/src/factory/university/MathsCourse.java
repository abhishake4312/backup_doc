package factory.university;

public class MathsCourse implements Course{
    @Override
    public void enroll() {
        System.out.println("Enrolling MathsCourse");
    }
}
