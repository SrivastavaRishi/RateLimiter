package ratelimiter;

public class RateLimiterPojo {
    private final int requestPerSeconds;
    private final int refillRatePerMillis;
    private final int leakRatePerMillis;

    private RateLimiterPojo(Builder builder) {
        this.requestPerSeconds = builder.requestPerSeconds;
        this.refillRatePerMillis = builder.refillRatePerMillis;
        this.leakRatePerMillis = builder.leakRatePerMillis;
    }

    // Getters
    public int getRequestPerSeconds() {
        return requestPerSeconds;
    }

    public int getRefillRatePerMillis() {
        return refillRatePerMillis;
    }

    public int getLeakRatePerMillis() {
        return leakRatePerMillis;
    }

    // Builder
    public static class Builder {
        private int requestPerSeconds;
        private int refillRatePerMillis;
        private int leakRatePerMillis;

        public Builder requestPerSeconds(int requestPerSeconds) {
            this.requestPerSeconds = requestPerSeconds;
            return this;
        }

        public Builder refillRatePerMillis(int refillRatePerMillis) {
            this.refillRatePerMillis = refillRatePerMillis;
            return this;
        }

        public Builder leakRatePerMillis(int leakRatePerMillis) {
            this.leakRatePerMillis = leakRatePerMillis;
            return this;
        }

        public RateLimiterPojo build() {
            return new RateLimiterPojo(this);
        }
    }
}
