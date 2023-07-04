package parking;

import parking.car.Car;
import parking.chargepolicy.ChargePolicy;
import parking.chargepolicy.ChargePolicyFactory;

import static parking.CarFixture.*;

public class Main {
    public static void main(String[] args) {
        final int basicTime = 30;
        final int basicCharge = 600;
        final int unitTime = 60;
        final int unitCharge = 1200;
        final int discountRatio = 50;

        Car[] cars = {
                CAR1.create(),
                CAR2.create(),
                CAR3.create(),
        };

        ChargePolicy chargePolicy = ChargePolicyFactory.builder()
                .basicTime(basicTime)
                .basicCharge(basicCharge)
                .unitTime(unitTime)
                .unitCharge(unitCharge)
                .discountRatio(discountRatio)
                .build();

        Cashier cashier = new Cashier();

        Parking parking = Parking.init(chargePolicy);
//        parking.in(cars[0], Time.of(7, 0)); // 캐셔 고용 전 입차
        parking.hire(cashier);

        parking.in(cars[0], Time.of(8, 0));
//        parking.in(cars[0], Time.of(8, 1)); // 중복 입차

        parking.in(cars[1], Time.of(8, 20));
        parking.in(cars[2], Time.of(8, 30));

        parking.out(cars[2], Time.of(8, 50));

        parking.out(cars[1], Time.of(17, 50));
        parking.out(cars[0], Time.of(17, 59));
    }
}
