package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Passenger;
import com.realdolmen.tickets.domain.Person;
import com.realdolmen.tickets.domain.Ticket;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface PassengerRepositoryRemote {
    Passenger save(Passenger passenger);
    Passenger findPassengerById(Long id);
    List<Passenger> findAll();
    void delete(Passenger passenger);
    Passenger mergePassenger(Passenger passenger);
    List<String> findAllLastNames();
    long totalFrequentFlyerMiles();
    List<Ticket> findTicketsByPassengerId(Long id);

}
