import ratelimiter.RateLimiter;
import ratelimiter.RateLimiterFactory;
import ratelimiter.RateLimiterPojo;
import ratelimiter.RateLimiterType;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = RateLimiterFactory.getRateLimiter(RateLimiterType.LEAKY_BUCKET,
                new RateLimiterPojo.Builder()
                        .requestPerMilliSeconds(2)
                        .capacity(10)
                        .build()
        );
        System.out.println(rateLimiter.allowRequest("user_1"));
        rateLimiter.block("user_1");
        System.out.println(rateLimiter.allowRequest("user_1"));
        rateLimiter.unblock("user_1");

        Thread.sleep(1000);
        System.out.println("New Batch !!");
        for(int i=0;i<13;i++){
            System.out.println(rateLimiter.allowRequest("user_1"));
        }

        Thread.sleep(1000);
        System.out.println("New Batch V2!!");
        System.out.println(rateLimiter.allowRequest("user_1"));
    }
}