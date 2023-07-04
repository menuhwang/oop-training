package parking.car;

import java.util.Objects;

public class Car {
    private final String id;
    private final Segment segment;

    public Car(final String id, final String segment) {
        this.id = id;
        this.segment = Segment.labelOf(segment);
    }

    public boolean isSegmentA() {
        return segment == Segment.A;
    }

    @Override
    public String toString() {
        return String.format("[Car] %s 차량번호:%s", segment.getLabel(), id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id.equals(car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
