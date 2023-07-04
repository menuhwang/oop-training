package parking.chargepolicy;

public class ChargePolicyFactory {
    public static ChargePolicyBuilder builder() {
        return new ChargePolicyBuilder();
    }
    public static class ChargePolicyBuilder {
        private Integer basicTime;
        private Integer basicCharge;
        private Integer unitTime;
        private Integer unitCharge;
        private Integer discountRatio;

        public ChargePolicyBuilder basicTime(int basicTime) {
            this.basicTime = basicTime;
            return this;
        }

        public ChargePolicyBuilder basicCharge(int basicCharge) {
            this.basicCharge = basicCharge;
            return this;
        }

        public ChargePolicyBuilder unitTime(int unitTime) {
            this.unitTime = unitTime;
            return this;
        }

        public ChargePolicyBuilder unitCharge(int unitCharge) {
            this.unitCharge = unitCharge;
            return this;
        }

        public ChargePolicyBuilder discountRatio(int discountRatio) {
            this.discountRatio = discountRatio;
            return this;
        }

        public ChargePolicy build() {
            if (isInvalid()) throw new RuntimeException("요금 정책 설정을 확인해주세요.");
            if (discountRatio == null || discountRatio == 0) return new DefaultChargePolicy(basicTime, basicCharge, unitTime, unitCharge);
            return new SegmentDiscountChargePolicy(basicTime, basicCharge, unitTime, unitCharge, discountRatio);
        }

        private boolean isInvalid() {
            return basicTime == null
                    || basicCharge == null
                    || unitTime == null
                    || unitCharge == null;
        }
    }
}
