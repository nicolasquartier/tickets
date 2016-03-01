package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Person;
import com.realdolmen.tickets.domain.Ticket;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface TicketRepositoryRemote {
    Ticket save(Ticket ticket);
    Ticket findById(Long id);
    List<Ticket> findAll();
    void deleteTicket(Ticket ticket);
    Ticket mergeTicket(Ticket ticket);
}
