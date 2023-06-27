package parking;

import java.util.Objects;

public class Car {
    private final String id;

    public Car(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("[Car] 차량번호:%s", id);
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
