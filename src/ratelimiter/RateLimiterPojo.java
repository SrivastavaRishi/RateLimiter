package ratelimiter;

public class RateLimiterPojo {
    private final int requestPerMilliSeconds;
    private final int refillRatePerMilliSeconds;
    private final int leakyBucketCapacity;

    private RateLimiterPojo(Builder builder) {
        this.requestPerMilliSeconds = builder.requestPerMilliSeconds;
        this.refillRatePerMilliSeconds = builder.refillRatePerMilliSeconds;
        this.leakyBucketCapacity = builder.leakyBucketCapacity;
    }

    // Getters
    public int getRequestPerMilliSeconds() {
        return requestPerMilliSeconds;
    }

    public int getRefillRatePerMilliSeconds() {
        return refillRatePerMilliSeconds;
    }

    public int getLeakyBucketCapacity() {
        return leakyBucketCapacity;
    }

    // Builder
    public static class Builder {
        private int requestPerMilliSeconds;
        private int refillRatePerMilliSeconds;
        private int leakyBucketCapacity;

        public Builder requestPerMilliSeconds(int requestPerMilliSeconds) {
            this.requestPerMilliSeconds = requestPerMilliSeconds;
            return this;
        }

        public Builder refillRatePerMilliSeconds(int refillRatePerMilliSeconds) {
            this.refillRatePerMilliSeconds = refillRatePerMilliSeconds;
            return this;
        }

        public Builder leakyBucketCapacity(int leakyBucketCapacity) {
            this.leakyBucketCapacity = leakyBucketCapacity;
            return this;
        }

        public RateLimiterPojo build() {
            return new RateLimiterPojo(this);
        }
    }
}
