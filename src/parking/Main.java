package parking;

import static parking.CarFixture.*;

public class Main {
    public static void main(String[] args) {
        final int basicTime = 30;
        final int basicCharge = 600;
        final int unitTime = 60;
        final int unitCharge = 1200;

        Car[] cars = {
                CAR1.create(),
                CAR2.create(),
                CAR3.create(),
        };

        ChargePolicy chargePolicy = new ChargePolicy(basicTime, basicCharge, unitTime, unitCharge);
        Cashier cashier = new Cashier();

        Parking parking = Parking.init(chargePolicy);
//        parking.in(cars[0], Time.of(7, 0));
        parking.hire(cashier);

        parking.in(cars[0], Time.of(8, 0));
        parking.in(cars[0], Time.of(8, 1));

        parking.in(cars[1], Time.of(8, 20));
        parking.in(cars[2], Time.of(8, 30));

        parking.out(cars[2], Time.of(8, 50));

        parking.out(cars[1], Time.of(17, 50));
        parking.out(cars[0], Time.of(17, 59));
    }
}
