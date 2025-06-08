import ratelimiter.RateLimiter;
import ratelimiter.RateLimiterFactory;
import ratelimiter.RateLimiterPojo;
import ratelimiter.RateLimiterType;

public class Main {
    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(RateLimiterType.LEAKY_BUCKET,
                new RateLimiterPojo.Builder()
                        .requestPerSeconds(100)
                        .leakRatePerMillis(10)
                        .build()
        );
        System.out.println(rateLimiter.allowRequest("user_1"));
    }
}