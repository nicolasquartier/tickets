package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Employee;
import com.realdolmen.tickets.domain.Passenger;
import com.realdolmen.tickets.domain.Person;
import com.realdolmen.tickets.domain.Ticket;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by NQRAZ66 on 19/02/2016.
 */
@Stateless
public class PassengerRepositoryBean implements PassengerRepositoryRemote{
    @PersistenceContext
    EntityManager em;


    public Passenger save(Passenger p) {
        em.persist(p);
        return p;
    }

    @Override
    public Passenger findPassengerById(Long id) {
        return em.find(Passenger.class, id);
    }

    @Override
    public List<Passenger> findAll() {
        return em.createQuery("select p from Passenger p", Passenger.class).getResultList();
    }

    @Override
    public void delete(Passenger passenger) {
        Passenger p = em.merge(passenger);//eerst mergen!!!
        for (Ticket t : p.getTickets()) {
            em.remove(t);
        }
        em.remove(p);
    }

    @Override
    public Passenger mergePassenger(Passenger passenger) {
        return em.merge(passenger);
    }

    @Override
    public List<String> findAllLastNames() {
        Query query =  em.createQuery("select p.lastName from Passenger p", String.class);
        return query.getResultList();
    }

    @Override
    public long totalFrequentFlyerMiles() {
        return em.createQuery("select sum(p.frequantFlyerMiles) from Passenger p", Long.class).getSingleResult();
    }

    @Override
    public List<Ticket> findTicketsByPassengerId(Long id) {
        Query q = em.createQuery("select t from Ticket t where t.passenger.id = :passengerId", Ticket.class);
        q.setParameter("passengerId", id);
        return q.getResultList();
    }

}
