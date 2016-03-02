package com.realdolmen.tickets.service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Date;

@Singleton
@Startup
public class TimerBeanTheDifficultWay {
    int count = 1;

    @Resource
    private TimerService timerService;

    @PostConstruct
    public void init() {
        ScheduleExpression expression = new ScheduleExpression()
                .second("*").minute("*").hour("*");

        timerService.createCalendarTimer(expression,
                new TimerConfig(null, false));
    }

    @Timeout
    public void trigger(Timer t) {
        System.out.println("Output " + new Date());
        if(count++ > 10) {
            t.cancel();
        }
    }
}
