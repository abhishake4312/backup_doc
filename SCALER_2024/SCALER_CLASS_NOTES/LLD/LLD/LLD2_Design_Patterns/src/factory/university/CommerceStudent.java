package factory.university;

public class CommerceStudent implements Student{
    @Override
    public Course getCourse() {
        return new EconomicsCourse();
    }
}
