package com.realdolmen.tickets.service;

import com.realdolmen.tickets.domain.Ticket;
import org.junit.Test;

import javax.ejb.NoSuchEJBException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by NQRAZ66 on 1/03/2016.
 */
public class ReservationServiceTest extends AbstractJndiTest {

    @Test
    public void shouldMakeReservation() throws Exception{
        ReservationServiceRemote rs = lookup("ticket-ear-1.0/ticket-ejb/ReservationService!com.realdolmen.tickets.service.ReservationServiceRemote");
        rs.identifyPassenger(3L);
        rs.choosePrice(500.0);
        rs.selectFlight(1L);
        Ticket ticket = rs.makeReservation();
        assertNotNull("Ticket shouldn't be null", ticket.getId());
    }

    @Test(expected = NoSuchEJBException.class)
    public void interfacingPostMakeReservationShouldThrowNoSuchEJBException() throws Exception{
        ReservationServiceRemote rs = lookup("ticket-ear-1.0/ticket-ejb/ReservationService!com.realdolmen.tickets.service.ReservationServiceRemote");
        rs.identifyPassenger(3L);
        rs.choosePrice(500.0);
        rs.selectFlight(1L);
        Ticket ticket = rs.makeReservation();
        rs.identifyPassenger(3L);
    }
}
