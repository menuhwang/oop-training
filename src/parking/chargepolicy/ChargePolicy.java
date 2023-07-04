package parking.chargepolicy;

import parking.car.Car;

public interface ChargePolicy {
    long calculate(final Car car, final long minutes);
}
