package com.realdolmen.tickets;

import javax.ejb.*;
import java.util.Date;

/**
 * Created by NQRAZ66 on 2/03/2016.
 */
@Singleton
@Startup
public class ClockEJB {

    private int counter = 0;

    @Schedule(hour = "*", minute = "*", second = "*", persistent = false, info = "info van de timer")
    public void printClockToConsole(Timer t) {
        if(counter < 10) {
            System.out.println(new Date());
            counter++;

        }
        else {
            System.out.println("Timer canceled: " + t.getInfo());
            t.cancel();
        }
    }
}
