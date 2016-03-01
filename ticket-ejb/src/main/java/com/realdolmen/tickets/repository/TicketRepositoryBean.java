package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Ticket;

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
public class TicketRepositoryBean implements TicketRepositoryRemote{
    @PersistenceContext
    EntityManager em;

    public Ticket save(Ticket t) {
        em.persist(t);
        return t;
    }

    public Ticket findById(Long id) {
        return em.find(Ticket.class, id);
    }

    public List<Ticket> findAll() {
        return em.createQuery("select t from Ticket t", Ticket.class).getResultList();
    }

    @Override
    public void deleteTicket(Ticket ticket) {
        em.remove(ticket);
    }

    @Override
    public Ticket mergeTicket(Ticket ticket) {
        return em.merge(ticket);
    }
}
