package parking.core.cashier;

import parking.core.Time;
import parking.core.car.Car;
import parking.core.chargepolicy.ChargePolicy;

import java.util.HashMap;

public class Cashier {
    private ChargePolicy chargePolicy;
    private HashMap<Car, Long> history;

    public Cashier() {
    }

    public void hired(ChargePolicy chargePolicy, HashMap<Car, Long> history) {
        this.chargePolicy = chargePolicy;
        this.history = history;
    }

    public void income(final Car car, final Time time) {
        // 차량 번호가 같은 경우 무반응
        if (history.containsKey(car)) return;
        writeHistory(car, time.getMinutes());
    }

    private void writeHistory(final Car car, final long minutes) {
        history.put(car, minutes);
    }

    public void outcome(final Car car, final Time time) {
        long minutes = time.getMinutes() - history.get(car);
        long charge = chargePolicy.calculate(car, minutes);
        notifyCharge(minutes, charge);
        removeHistory(car);
    }

    private void removeHistory(final Car car) {
        history.remove(car);
    }

    private void notifyCharge(final long minutes, final long charge) {
        System.out.println("[Cashier]");
        System.out.printf("이용 시간: %d[min]\n", minutes);
        System.out.printf("요금: %d[원]\n", charge);
    }
}
