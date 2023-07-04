package parking.chargepolicy;

import parking.car.Car;

public class SegmentDiscountChargePolicy extends DefaultChargePolicy {
    private final int discountRatio;

    public SegmentDiscountChargePolicy(final int basicTime, final int basicCharge, final int unitTime, final int unitCharge, final int discountRatio) {
        super(basicTime, basicCharge, unitTime, unitCharge);
        this.discountRatio = discountRatio;
    }

    @Override
    public long calculate(final Car car, final long minutes) {
        long charge = super.calculate(car, minutes);
        if (car.isSegmentA()) return discount(charge);
        return charge;
    }

    private long discount(final long charge) {
        return (long) ((float) charge / 100 * (100 - discountRatio));
    }
}
