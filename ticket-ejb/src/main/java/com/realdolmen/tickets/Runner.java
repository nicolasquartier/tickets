package com.realdolmen.tickets;

import javax.annotation.Resource;
import javax.ejb.TimerService;
import java.util.concurrent.*;

public class Runner {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ClockEJB clock = new ClockEJB();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        myTask task = new myTask();

        long start = System.nanoTime();

        Future<Integer> r = executorService.submit(task);

        System.out.println("Doing extra work while waiting");
        Thread.sleep(3000);
        System.out.println("Doing more extra work while waiting");
        Thread.sleep(3000);
        System.out.println("extra work done");

        Integer i = r.get();


        long end = System.nanoTime();
        System.out.println("Done after " + ((end - start) / 1000000000) + " seconds: " + i);
    }
}

class myTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("Still calculating...");
            Thread.sleep(1000);
        }
        return 5 * 8;
    }
}
