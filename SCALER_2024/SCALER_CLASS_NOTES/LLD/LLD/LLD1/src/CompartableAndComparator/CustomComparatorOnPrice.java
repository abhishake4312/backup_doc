package CompartableAndComparator;

import java.util.Comparator;

public class CustomComparatorOnPrice implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.price - o2.price;
    }
}
