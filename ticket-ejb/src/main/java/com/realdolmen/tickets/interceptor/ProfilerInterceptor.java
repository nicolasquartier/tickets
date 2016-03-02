package com.realdolmen.tickets.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 * Created by NQRAZ66 on 2/03/2016.
 */
public class ProfilerInterceptor {

    @AroundInvoke
    public Object logExecuteTime(InvocationContext ic) throws Exception {
        long startTime = System.nanoTime();

        Object o = ic.proceed();

        long endTime = System.nanoTime();
        long result = (endTime - startTime) / 1000000000;
        System.out.println("Time to execute " + ic.getMethod().getName() + ": " + result);

        return o;
    }
}
