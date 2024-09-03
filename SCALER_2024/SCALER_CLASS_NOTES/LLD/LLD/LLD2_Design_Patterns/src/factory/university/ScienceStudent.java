package factory.university;

public class ScienceStudent implements Student{
    @Override
    public Course getCourse() {
        return new MathsCourse();
    }
}
