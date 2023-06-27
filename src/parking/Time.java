package parking;

public class Time {
    private final int hour;
    private final int minute;

    private Time(final int hour, final int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public static Time of(final int hour, final int minute) {
        return new Time(hour, minute);
    }

    public long getMinutes() {
        return (long) hour * 60 + minute;
    }
}
