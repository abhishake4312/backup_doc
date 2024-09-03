package factory.simplefactory;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        //Client class should not create objects of car based on different condition
        //It is voilating the OCP and client need to be aware of various concrete classes of Car
        //The actual car object is decided at runtime
        Scanner sc = new Scanner(System.in);
        int carType=sc.nextInt();
//        Car car=null;
//        if(carType==1){
//            car=new Sedan();
//        }else if(carType==2){
//            car=new SUV();
//        }
//        car.drive();1


        Car car=CarFactory.createCar(carType);
        car.drive();
    }
}
