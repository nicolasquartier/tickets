package com.realdolmen.tickets.service;

import com.realdolmen.tickets.domain.Ticket;

import javax.ejb.Remote;

/**
 * Created by NQRAZ66 on 1/03/2016.
 */
@Remote
public interface ReservationServiceRemote {
    void identifyPassenger(Long id);
    void choosePrice(double price);
    void selectFlight(Long id);
    Ticket makeReservation();

}
