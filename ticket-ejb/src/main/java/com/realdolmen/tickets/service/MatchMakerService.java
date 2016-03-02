package com.realdolmen.tickets.service;


import com.realdolmen.tickets.domain.Person;
import com.realdolmen.tickets.interceptor.ProfilerInterceptor;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Interceptors(ProfilerInterceptor.class)
public class MatchMakerService implements MatchMakerRemote {

    @EJB
    private PersonServiceBean personServiceBean;

    private HashMap<String, Integer> cache = new HashMap<>();

    @Lock(LockType.READ)
    public Map<String, Integer> getCache() {
        return new HashMap<>(cache);
    }

    @Override
    @Lock(LockType.WRITE)
    public int match(String a, String b) {
        for(int i=0; i<5; i++ ) {
            linger();
            System.out.println("Calculating " + a + " " + b);
        }

        String key = a + b;
        Integer percentage = cache.get(key);
        if (percentage == null) {
            percentage = a.hashCode() * b.hashCode() % 101;
            cache.put(key, percentage);
            System.out.println("Cache miss");
        } else {
            System.out.println("Cache hit");
        }
        return percentage;
    }

    private void linger()  {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException("Unable to linger", e);
        }
    }

    @Override
    @Asynchronous
    public Future<Integer> matchAsync(String a, String b) {
        return new AsyncResult<>(match(a, b));
    }
}
