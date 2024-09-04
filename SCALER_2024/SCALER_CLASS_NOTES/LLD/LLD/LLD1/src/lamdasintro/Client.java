package lamdasintro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Thread t =new Thread(()-> System.out.println("printing on new thread"));
        t.start();

        List<Car> carList=new ArrayList<>();
        Car c1=new Car(110,25);
        Car c2=new Car(120,15);
        Car c3=new Car(90,20);
        carList.add(c1);
        carList.add(c2);
        carList.add(c3);

        //way2 Anonymous classes
        Collections.sort(carList, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.topSpeed-o2.topSpeed;
            }
        });

        //way3 Lamdas
        Collections.sort(carList,(o1,o2)->o1.topSpeed-o2.topSpeed);
    }

}
