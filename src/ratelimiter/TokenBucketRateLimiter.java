package ratelimiter;

import java.util.HashMap;
import java.util.Map;

public class TokenBucketRateLimiter extends RateLimiter {
    private final int capacity; // max tokens
    private final double refillRatePerMillis; // tokens added per millisecond

    private static class Bucket {
        double tokens;
        long lastRefillTime;

        public Bucket(double tokens, long lastRefillTime) {
            this.tokens = tokens;
            this.lastRefillTime = lastRefillTime;
        }
    }

    private final Map<String, Bucket> userBuckets = new HashMap<>();

    public TokenBucketRateLimiter(RateLimiterPojo rateLimiterPojo) {
        this.capacity = rateLimiterPojo.getRequestPerSeconds();
        this.refillRatePerMillis = rateLimiterPojo.getRefillRatePerMillis() / 1000.0;
    }

    public boolean allowRequest(String userId) {
        if(isBlocked(userId)){
            return false;
        }
        long currentTime = System.currentTimeMillis();
        Bucket bucket = userBuckets.computeIfAbsent(userId,
                _ -> new Bucket(capacity, currentTime));

        // Refill tokens
        long elapsed = currentTime - bucket.lastRefillTime;
        double newTokens = elapsed * refillRatePerMillis;
        bucket.tokens = Math.min(capacity, bucket.tokens + newTokens);
        bucket.lastRefillTime = currentTime;

        if (bucket.tokens >= 1) {
            bucket.tokens -= 1; // Allow request
            return true;
        } else {
            return false; // Reject request
        }
    }
}

