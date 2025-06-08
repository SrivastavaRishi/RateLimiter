package ratelimiter;

public class RateLimiterPojo {
    private final int requestPerSeconds;
    private final int refillRatePerMillis;
    private final int capacity;

    private RateLimiterPojo(Builder builder) {
        this.requestPerSeconds = builder.requestPerSeconds;
        this.refillRatePerMillis = builder.refillRatePerMillis;
        this.capacity = builder.capacity;
    }

    // Getters
    public int getRequestPerSeconds() {
        return requestPerSeconds;
    }

    public int getRefillRatePerMillis() {
        return refillRatePerMillis;
    }

    public int getCapacity() {
        return capacity;
    }

    // Builder
    public static class Builder {
        private int requestPerSeconds;
        private int refillRatePerMillis;
        private int capacity;

        public Builder requestPerSeconds(int requestPerSeconds) {
            this.requestPerSeconds = requestPerSeconds;
            return this;
        }

        public Builder refillRatePerMillis(int refillRatePerMillis) {
            this.refillRatePerMillis = refillRatePerMillis;
            return this;
        }

        public Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public RateLimiterPojo build() {
            return new RateLimiterPojo(this);
        }
    }
}
