package ratelimiter;

import lombok.NonNull;

public class RateLimiterFactory {
    public static RateLimiter getRateLimiter(RateLimiterType rateLimiterType, @NonNull RateLimiterPojo rateLimiterPojo){
        switch (rateLimiterType){
            case LEAKY_BUCKET -> {
                return new LeakyBucketRateLimiter(rateLimiterPojo);
            }
            default -> {
                throw new IllegalArgumentException("Invalid rate limiter");
            }
        }
    }
}
