package parking;

import parking.car.Car;

public enum CarFixture {
    CAR1("11차 0000", "경차"),
    CAR2("20차 1000", "소형차"),
    CAR3("00차 1200", "중형차"),
    ;

    private final String id;
    private final String segment;

    CarFixture(String id, String segment) {
        this.id = id;
        this.segment = segment;
    }

    public Car create() {
        return new Car(id, segment);
    }
}
