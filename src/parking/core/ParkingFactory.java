package parking.core;

import parking.core.chargepolicy.ChargePolicyFactory;

public class ParkingFactory {
    public static Parking newParking() {
        return new Parking(ChargePolicyFactory.getInstance());
    }
}
