package parking;

public enum CarFixture {
    CAR1("11차 0000"),
    CAR2("20차 1000"),
    CAR3("00차 1200"),
    ;

    private final String id;

    CarFixture(String id) {
        this.id = id;
    }

    public Car create() {
        return new Car(id);
    }
}
