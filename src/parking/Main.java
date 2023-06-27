package parking;

public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        Car car1 = new Car("11차 0000");
        Car duplicated = new Car("11차 0000");
        Car car2 = new Car("20차 1000");
        Car car3 = new Car("00차 1200");

        parking.printInfo();

        parking.in(car1);
        parking.in(duplicated);
        parking.printInfo();

        parking.in(car2);
        parking.in(car3);
        parking.printInfo();

        parking.out(car1);
        parking.printInfo();
    }
}
