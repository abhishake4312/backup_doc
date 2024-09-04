package lamdasintro;

public class Car {

    public int topSpeed;
    public int mileage;
    Car(int topSpeed, int mileage) {
        this.topSpeed = topSpeed;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "topSpeed=" + topSpeed +
                ", mileage=" + mileage +
                '}';
    }
}
