package parking.core.chargepolicy;

import parking.core.car.Car;

public interface ChargePolicy {
    void setBasicTime(int basicTime);
    void setBasicCharge(int basicCharge);
    void setUnitTime(int unitTime);
    void setUnitCharge(int unitCharge);
    long calculate(final Car car, final long minutes);
}
