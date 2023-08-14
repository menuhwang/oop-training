package parking.core.chargepolicy;

import parking.core.car.Car;

public class DefaultChargePolicy implements ChargePolicy {
    private static final int DEFAULT_BASIC_TIME = 30;
    private static final int DEFAULT_BASIC_CHARGE = 2000;
    private static final int DEFAULT_UNIT_TIME = 10;
    private static final int DEFAULT_UNIT_CHARGE = 500;
    protected int basicTime;
    protected int basicCharge;
    protected int unitTime;
    protected int unitCharge;

    DefaultChargePolicy() {
        this(DEFAULT_BASIC_TIME, DEFAULT_BASIC_CHARGE, DEFAULT_UNIT_TIME, DEFAULT_UNIT_CHARGE);
    }

    protected DefaultChargePolicy(final int basicTime, final int basicCharge, final int unitTime, final int unitCharge) {
        this.basicTime = basicTime;
        this.basicCharge = basicCharge;
        this.unitTime = unitTime;
        this.unitCharge = unitCharge;
    }

    @Override
    public void setBasicTime(int basicTime) {
        this.basicTime = basicTime;
    }

    @Override
    public void setBasicCharge(int basicCharge) {
        this.basicCharge = basicCharge;
    }

    @Override
    public void setUnitTime(int unitTime) {
        this.unitTime = unitTime;
    }

    @Override
    public void setUnitCharge(int unitCharge) {
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
