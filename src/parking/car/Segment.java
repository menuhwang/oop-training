package parking.car;

public enum Segment {
    A("경차"),
    B("소형차"),
    C("준중형차"),
    D("중형차"),
    E("준대형차"),
    J("SUV"),
    ;

    private final String label;

    Segment(String label) {
        this.label = label;
    }

    public static Segment labelOf(String label) {
        for (Segment segment : values()) {
            if (segment.label.equals(label)) return segment;
        }
        throw new EnumConstantNotPresentException(Segment.class, label);
    }

    public String getLabel() {
        return label;
    }
}
