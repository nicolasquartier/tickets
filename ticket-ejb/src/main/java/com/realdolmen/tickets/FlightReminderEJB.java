package com.realdolmen.tickets;

import com.realdolmen.tickets.domain.Flight;
import com.realdolmen.tickets.domain.Passenger;
import com.realdolmen.tickets.domain.Ticket;
import com.realdolmen.tickets.repository.FlightRepositoryBean;
import com.realdolmen.tickets.repository.PassengerRepositoryBean;
import com.realdolmen.tickets.repository.TicketRepositoryBean;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import javax.ejb.*;

/**
 * Created by NQRAZ66 on 2/03/2016.
 */
@Singleton
@Startup
public class FlightReminderEJB {

    @PersistenceContext
    EntityManager em;

    @EJB
    PassengerRepositoryBean passengerRepository;

    @EJB
    TicketRepositoryBean ticketRepositoryBean;

    @EJB
    FlightRepositoryBean flightRepositoryBean;

    @Schedule(hour = "0", minute = "0", second = "*", dayOfMonth = "*", month = "*", year = "*", persistent = false)
    public void remindPassengersByEmailOfTheirFlight(/*Timer timer*/) {
        Passenger p = passengerRepository.findPassengerById(3L);
        Flight flightOut = flightRepositoryBean.findById(1L);
        Flight flightReturn = flightRepositoryBean.findById(2L);
        ticketRepositoryBean.save(new Ticket(200.0, p, flightOut, flightReturn));

        List<Ticket> tickets = em.createQuery("select t from Ticket t", Ticket.class).getResultList();
        for (Ticket ticket : tickets) {
            p = ticket.getPassenger();
            Flight f = ticket.getFlightOut();
            if(f.getDepartureTime().getTime() < new Date().getTime()) {
                System.out.println("Flight already lift off, e-mail to passenger he's too late");
                System.out.println(p.getFirstName() + ": You missed your flight");
                System.out.println("lift off: " + f.getDepartureTime() + "; now: " + new Date());
            }
        }

        //timer.cancel();//voor oefening slechts éénmaal uitvoeren
        //(hour = "*", minute = "0", second = "0", dayOfMonth = "*", month = "*", year = "*", persistent = false)
    }
}
