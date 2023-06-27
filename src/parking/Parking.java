package parking;

import java.util.HashMap;

public class Parking {
    private final ChargePolicy chargePolicy;
    private final HashMap<Car, Long> history = new HashMap<>();

    private Parking(final ChargePolicy chargePolicy) {
        this.chargePolicy = chargePolicy;
    }

    public static Parking init(final ChargePolicy chargePolicy) {
        return new Parking(chargePolicy);
    }

    public void in(final Car car, final Time time) {
        // 차량 번호가 같은 경우 무반응
        if (history.containsKey(car)) return;
        System.out.println("입차");
        System.out.printf("<-- %s\n", car);
        history.put(car, time.getMinutes());
        printInfo();
    }

    public void out(final Car car, final Time time) {
        long minutes = time.getMinutes() - history.get(car);
        long charge = chargePolicy.calculate(minutes);
        System.out.println("출차");
        System.out.printf("--> %s\n이용 시간:%d[min] 요금:%d\n", car, minutes, charge);
        history.remove(car);
        printInfo();
    }

    public void printInfo() {
        System.out.println("==========================================================");
        System.out.printf("현재 주차 상황 %d대\n", history.size());
        int index = 1;
        for (Car car : history.keySet()) {
            System.out.printf("%d : %s\n", index++, car);
        }
        System.out.println("==========================================================\n");
    }
}
