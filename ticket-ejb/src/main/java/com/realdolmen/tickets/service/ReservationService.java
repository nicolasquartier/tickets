package com.realdolmen.tickets.service;

import com.realdolmen.tickets.domain.Flight;
import com.realdolmen.tickets.domain.Passenger;
import com.realdolmen.tickets.domain.Ticket;
import com.realdolmen.tickets.repository.FlightRepositoryBean;
import com.realdolmen.tickets.repository.PassengerRepositoryBean;
import com.realdolmen.tickets.repository.TicketRepositoryBean;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by NQRAZ66 on 1/03/2016.
 */
@Stateful
public class ReservationService implements ReservationServiceRemote {

    @EJB
    private PassengerRepositoryBean passengerBean;

    @EJB
    private TicketRepositoryBean ticketBean;

    @EJB
    private FlightRepositoryBean flightBean;

    private Passenger passenger;
    private Flight flight;
    private Ticket ticket;
    private double price;

    public ReservationService() {}

    @Override
    public void identifyPassenger(Long id) {
        passenger = passengerBean.findPassengerById(id);
    }

    @Override
    public void choosePrice(double p) {
        price = p;
    }

    @Override
    public void selectFlight(Long id) {
        flight = flightBean.findById(id);
    }

    @Override
    public Ticket makeReservation() {
        ticket = new Ticket();
        ticket.setPassenger(passenger);
        ticket.setFlightOut(flight);
        ticket.setPrice(price);
        ticketBean.save(ticket);
        return ticket;
    }
}
