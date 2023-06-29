package parking;

import java.util.HashMap;

public class Parking {
    private final ChargePolicy chargePolicy;
    private Cashier cashier;
    private final HashMap<Car, Long> history = new HashMap<>();

    private Parking(final ChargePolicy chargePolicy) {
        this.chargePolicy = chargePolicy;
    }

    public static Parking init(final ChargePolicy chargePolicy) {
        return new Parking(chargePolicy);
    }

    public void hire(final Cashier cashier) {
        this.cashier = cashier;
        cashier.hire(history);
    }

    public void in(final Car car, final Time time) {
        if (!verifyStatus()) return;

        System.out.println("[Parking]");
        System.out.printf("입차 <-- %s\n", car);

        cashier.income(car, time);

        printInfo();
    }

    public void out(final Car car, final Time time) {
        if (!verifyStatus()) return;

        System.out.println("[Parking]");
        System.out.printf("출차 --> %s\n", car);

        cashier.outcome(car, time, chargePolicy);

        printInfo();
    }

    public void printInfo() {
        System.out.println("[Info]");
        System.out.printf("현재 주차 상황 %d대\n", history.size());
        System.out.println("==========================================================");
        int index = 1;
        for (Car car : history.keySet()) {
            System.out.printf("%d : %s\n", index++, car);
        }
        System.out.println("==========================================================\n");
    }

    private boolean verifyStatus() {
        if (cashier == null) {
            System.out.println("[Parking]\n캐셔 고용이 필요합니다.\n");
            return false;
        }
        return true;
    }
}
