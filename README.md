Problem Statement

Rate Limiter for 
1. 1000 http apis 
2. rate limit of 200 req within 1 sec for every user - other user shouldn't be impacted
3. library with all handy function for before calling http.

Assumption:
1. Created a rate limited on basis on userId, assuming user is logged in, before call is made.
2. In case, user is not logged in system, this can be changed to IP level.

Implementation: 
1. Used leaky bucket rate limiter algo.
2. The Concrete class will have capacity of bucket and the leak rate.
3. According to the time elapsed, decision will be taken, whether to accept request or reject.
4. Apart from this RateLimiter class will have set of blocked users.
5. We can block/unblock user and get blocked status for a user.
6. Created a RateLimiter Interface and the different algo can extend this abstract class in the library. Hence making it extensible.
