package factory.simplefactory;

public class CarFactory {

    //This is a practical CarFactory which return the object of class type
   static Car createCar(int input){
        if(input == 1){
            return new Sedan();
        }else if(input == 2){
            return new SUV();
        }
        return null;
    }
}
