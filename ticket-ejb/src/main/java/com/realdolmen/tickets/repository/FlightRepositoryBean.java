package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.DomesticFlight;
import com.realdolmen.tickets.domain.Flight;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by NQRAZ66 on 22/02/2016.
 */
@Stateless
@LocalBean
public class FlightRepositoryBean implements FlightRepositoryRemote{
    @PersistenceContext
    EntityManager em;

    @Override
    public Flight save(Flight flight) {
        em.persist(flight);
        return flight;
    }

    @Override
    public Flight findById(Long id) {
        return em.find(Flight.class, id);
    }

    @Override
    public DomesticFlight findByIdDomestic(Long id) {
        return em.find(DomesticFlight.class, id);
    }

    @Override
    public List<Flight> findAll() {
        return em.createQuery("select f from Flight f", Flight.class).getResultList();
    }

    @Override
    public List<DomesticFlight> findAllDomesticFlights() {
        return em.createQuery("select f from DomesticFlight f", DomesticFlight.class).getResultList();
    }
}
