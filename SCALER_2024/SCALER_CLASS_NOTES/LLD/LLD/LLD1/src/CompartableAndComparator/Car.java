package CompartableAndComparator;

public class Car {

     int topSpeed;
     int mileage;
     int price;
    public Car(int topSpeed, int mileage, int price) {
        this.topSpeed = topSpeed;
        this.mileage = mileage;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "topSpeed=" + topSpeed +
                ", mileage=" + mileage +
                ", price=" + price +
                '}';
    }
}
