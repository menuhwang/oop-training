package parking.core.chargepolicy;

public class ChargePolicyFactory {
    private static ChargePolicy CHARGE_POLICY = new DefaultChargePolicy();

    public static ChargePolicy getInstance() {
        return CHARGE_POLICY;
    }

    public static void setBasicTime(int basicTime) {
        CHARGE_POLICY.setBasicTime(basicTime);
    }

    public static void setBasicCharge(int basicCharge) {
        CHARGE_POLICY.setBasicCharge(basicCharge);
    }

    public static void setUnitTime(int unitTime) {
        CHARGE_POLICY.setUnitTime(unitTime);
    }

    public static void setUnitCharge(int unitCharge) {
        CHARGE_POLICY.setUnitCharge(unitCharge);
    }

    public static void registerChargePolicy(ChargePolicy chargePolicy) {
        CHARGE_POLICY = chargePolicy;
    }
}
