package ratelimiter;

public class RateLimiterPojo {
    private final int requestPerMilliSeconds;
    private final int refillRatePerMilliSeconds;
    private final int capacity;

    private RateLimiterPojo(Builder builder) {
        this.requestPerMilliSeconds = builder.requestPerMilliSeconds;
        this.refillRatePerMilliSeconds = builder.refillRatePerMilliSeconds;
        this.capacity = builder.capacity;
    }

    // Getters
    public int getRequestPerMilliSeconds() {
        return requestPerMilliSeconds;
    }

    public int getRefillRatePerMilliSeconds() {
        return refillRatePerMilliSeconds;
    }

    public int getCapacity() {
        return capacity;
    }

    // Builder
    public static class Builder {
        private int requestPerMilliSeconds;
        private int refillRatePerMilliSeconds;
        private int capacity;

        public Builder requestPerMilliSeconds(int requestPerMilliSeconds) {
            this.requestPerMilliSeconds = requestPerMilliSeconds;
            return this;
        }

        public Builder refillRatePerMillis(int refillRatePerMilliSeconds) {
            this.refillRatePerMilliSeconds = refillRatePerMilliSeconds;
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
