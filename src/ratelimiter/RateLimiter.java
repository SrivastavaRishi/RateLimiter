package ratelimiter;

import java.util.HashSet;
import java.util.Set;

public abstract class RateLimiter {

    Set<String> blockedUsers = new HashSet<>();

    public abstract boolean allowRequest(String userId);

    public void block(String userId){
        try{
            blockedUsers.add(userId);
        } catch (Exception e){
            throw new RateLimiterException("Error while blocking the user" + userId);
        }
    }

    public void unblock(String userId){
        try{
            blockedUsers.remove(userId);
        } catch (Exception e){
            throw new RateLimiterException("Error while blocking the user" + userId);
        }
    }

    public boolean isBlocked(String userId){
        return blockedUsers.contains(userId);
    }
}
