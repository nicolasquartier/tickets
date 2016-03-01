package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.DomesticFlight;
import com.realdolmen.tickets.domain.Flight;
import com.realdolmen.tickets.domain.Ticket;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface FlightRepositoryRemote {
    Flight save(Flight flight);
    Flight findById(Long id);
    Flight findByIdDomestic(Long id);
    List<Flight> findAll();
    List<DomesticFlight> findAllDomesticFlights();
}
