package CompartableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {
    public static void main(String[] args) {
        Car c1=new Car(200,25,200000);
        Car c2=new Car(150,20,150000);
        Car c3=new Car(250,15,450000);
        List<Car> cars=new ArrayList<Car>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        // Below will give error as java is not sure on which attribute it has to sort
       // Collections.sort(cars);

//        Collections.sort(cars,new Comparator<Car>() {
//
//            @Override
//            public int compare(Car o1, Car o2) {
//                return o1.topSpeed-o2.topSpeed;
//            }
//        });

        Collections.sort(cars,(o1,o2)->o2.topSpeed-o1.topSpeed);
        for(Car car:cars){
            System.out.println(car);
        }

        Collections.sort(cars,new CustomComparatorOnPrice());
        for(Car car:cars){
            System.out.println(car);
        }
    }
}
