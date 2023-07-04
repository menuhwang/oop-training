package parking.chargepolicy;

import parking.car.Car;

public class DefaultChargePolicy implements ChargePolicy {
    private final int basicTime;
    private final int basicCharge;
    private final int unitTime;
    private final int unitCharge;

    public DefaultChargePolicy(final int basicTime, final int basicCharge, final int unitTime, final int unitCharge) {
        this.basicTime = basicTime;
        this.basicCharge = basicCharge;
        this.unitTime = unitTime;
        this.unitCharge = unitCharge;
    }

    @Override
    public long calculate(final Car car, final long minutes) {
        if (minutes <= basicTime) return basicCharge;
        long overMinutes = minutes - basicTime;
        long unit = overMinutes % unitTime == 0 ? overMinutes / unitTime : (overMinutes / unitTime) + 1;
        return basicCharge + unit * unitCharge;
    }
}
