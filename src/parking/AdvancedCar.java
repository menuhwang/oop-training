package parking;

import parking.core.car.Car;

public class AdvancedCar extends Car {
    private final Segment segment;

    public AdvancedCar(final String id, final String segment) {
        super(id);
        this.segment = Segment.labelOf(segment);
    }

    public boolean isSegmentA() {
        return segment == Segment.A;
    }

    @Override
    public String toString() {
        return String.format("[Car] %s 차량번호:%s", segment.getLabel(), id);
    }
}
