package parking;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Parking {
    private final Set<Car> cars = new HashSet<>();

    public void in(Car car) {
        // 차량 번호가 같은 경우 무반응
        if (cars.contains(car)) return;
        System.out.printf("입차 %s\n", car);
        cars.add(car);
    }

    public void out(Car car) {
        System.out.printf("출차 %s\n", car);
        cars.remove(car);
    }

    public void printInfo() {
        System.out.println("==========================================================");
        System.out.printf("[%s] 현재 주차 상황 %d대\n", LocalDateTime.now(), cars.size());
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println("==========================================================");
    }
}
