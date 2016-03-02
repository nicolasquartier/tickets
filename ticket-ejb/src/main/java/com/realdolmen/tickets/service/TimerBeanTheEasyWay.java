package com.realdolmen.tickets.service;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timer;
import java.util.Date;

@Singleton
@Startup
public class TimerBeanTheEasyWay {
    int count = 1;

    @Schedule(second = "*", minute = "*", hour = "*", persistent = false)
    public void displayTime(Timer t) {
        System.out.println("TIMER " + new Date());
        if(count++ == 10) {
            t.cancel();
        }
    }
}
