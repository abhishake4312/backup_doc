package factory.simplefactory;

public class Sedan implements Car{
    @Override
    public void drive() {
        System.out.println( "Sedan drive" );
    }
}
