package ratelimiter;

import java.util.*;

public class LeakyBucketRateLimiter implements RateLimiter {
    private static final int INITIAL_CAPACITY = 1000;
    private final int capacity;
    private final double leakRatePerMillis; // requests per millisecond

    private static class Bucket {
        double water; // current water level (in requests)
        long lastUpdated; // last leak timestamp in millis

        public Bucket() {
            this.water = 0.0;
            this.lastUpdated = System.currentTimeMillis();
        }
    }

    private final Map<String, Bucket> userBuckets = new HashMap<>();

    public LeakyBucketRateLimiter( RateLimiterPojo rateLimiterPojo) {
        this.leakRatePerMillis = rateLimiterPojo.getRequestPerSeconds() / 1000.0;
        this.capacity = rateLimiterPojo.getLeakRatePerMillis() != 0 ? rateLimiterPojo.getLeakRatePerMillis():  INITIAL_CAPACITY;
    }

    @Override
    public boolean allowRequest(String userId) {
        Bucket bucket = userBuckets.computeIfAbsent(userId, k -> new Bucket());
        long currentTime = System.currentTimeMillis();

        // Leak out water since last request
        long elapsed = currentTime - bucket.lastUpdated;
        double leaked = elapsed * leakRatePerMillis;
        bucket.water = Math.max(0.0, bucket.water - leaked);
        bucket.lastUpdated = currentTime;

        if (bucket.water < capacity) {
            bucket.water += 1; // Accept this request
            return true;
        } else {
            // Bucket is full, reject request
            return false;
        }
    }
}
