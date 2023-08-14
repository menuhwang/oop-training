package parking;

import parking.core.Parking;
import parking.core.ParkingFactory;
import parking.core.Time;
import parking.core.car.Car;
import parking.core.cashier.Cashier;
import parking.core.chargepolicy.ChargePolicyFactory;

import static parking.CarFixture.*;

public class Main {
    public static void main(String[] args) {
        final int basicTime = 30;
        final int basicCharge = 600;
        final int unitTime = 60;
        final int unitCharge = 1200;
        final int discountRatio = 50;

        Car[] cars = {
                new AdvancedCar(CAR1.getId(), CAR1.getSegment()),
                new AdvancedCar(CAR2.getId(), CAR2.getSegment()),
                new AdvancedCar(CAR3.getId(), CAR3.getSegment()),
        };

        ChargePolicyFactory.registerChargePolicy(new SegmentDiscountChargePolicy(basicTime, basicCharge, unitTime, unitCharge, discountRatio));
        Parking parking = ParkingFactory.newParking();

//        parking.in(cars[0], Time.of(7, 0)); // 캐셔 고용 전 입차

        Cashier cashier = new Cashier();
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
