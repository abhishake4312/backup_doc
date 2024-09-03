package CompartableAndComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableMain {
    public static void main(String[] args) {
        CarComparable c1=new CarComparable(200,25,200000);
        CarComparable c2=new CarComparable(200,20,150000);
        CarComparable c3=new CarComparable(250,15,450000);
        List<CarComparable> cars=new ArrayList<CarComparable>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        // Below will give error as java is not sure on which attribute it has to sort
        // Collections.sort(cars);
        //If we have to compare on default or natural attribute like topspeed implement Comparable in CarComparable

        //now sorting will not give any issue as it is comparing on default natural aatribute topspeed
        Collections.sort(cars);

        for (CarComparable car : cars) {
            System.out.println(car);
        }
    }
}
