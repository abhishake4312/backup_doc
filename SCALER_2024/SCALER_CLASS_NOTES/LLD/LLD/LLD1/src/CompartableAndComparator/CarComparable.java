package CompartableAndComparator;

public class CarComparable implements Comparable<CarComparable> {
    int topSpeed;
    int mileage;
    int price;
    public CarComparable(int topSpeed, int mileage, int price) {
        this.topSpeed = topSpeed;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarComparable{" +
                "topSpeed=" + topSpeed +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(CarComparable o) {

        if(this.topSpeed==o.topSpeed){
            return this.mileage - o.mileage;
        }
        return this.topSpeed - o.topSpeed;
    }
}


