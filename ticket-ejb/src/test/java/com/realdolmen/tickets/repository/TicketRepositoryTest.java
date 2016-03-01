package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Flight;
import com.realdolmen.tickets.domain.Passenger;
import com.realdolmen.tickets.domain.Ticket;
import org.junit.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by NQRAZ66 on 19/02/2016.
 */
public class TicketRepositoryTest {

    private static EntityManagerFactory emf;
    private static EntityTransaction tx;
    private static TicketRepositoryBean tr;

    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory("Test");
        tr = new TicketRepositoryBean();
    }

    @AfterClass
    public static void closeEntityManager() throws Exception {
        emf.close();
    }

    @Before
    public void initTransaction() {
        tr.em = emf.createEntityManager();
        tx = tr.em.getTransaction();
        tx.begin();

    }

    @After
    public void closeTransation() {
        tx.rollback();
        tr.em.close();
    }

    @Test
    public void shouldSaveTicket() {
        Passenger p = new Passenger("123-456-789", "Nicolas", new Date(0), "Quartier", 1000);
        Flight fOut = new Flight("123");
        Flight fReturn = new Flight("456");

        tr.em.persist(p);
        tr.em.persist(fOut);
        tr.em.persist(fReturn);
        tr.em.flush();
        assertNotNull(fOut.getId());
        assertNotNull(fReturn.getId());
        assertNotNull(p.getId());

        Ticket t = new Ticket(200.0, p, fOut, fReturn);
        assertNull("Ticket's id must be null", t.getId());
        tr.save(t);
        tr.em.flush();
        assertNotNull("Ticket's id should not be null because saved!", t.getId());
    }

    @Test
    public void shouldFindTicketByid() {
        Ticket t = tr.findById(1L);
        assertNotNull("Ticket should be in table to find", t);
        assertEquals(new Long(1L), t.getId());
        //assertEquals(200.0, t.getPrice());
    }

    @Test
    public void shouldFindAllTickets() {
        List<Ticket> list = tr.findAll();
        assertNotNull(list);
        assertEquals(2, list.size());
    }

    @Test
    public void shouldDeleteTicket() {
        Ticket t = tr.findById(1L);
        assertNotNull("Ticket's id should not be null because saved!", t.getId());
        tr.deleteTicket(t);
        tr.em.flush();
        t = tr.findById(1L);
        assertNull("Ticket's id must be null", t);
    }

    @Test
    public void shouldUpdateTicket() {
        Ticket t = tr.findById(1L);
        assertNotNull("Ticket's id should not be null because saved!", t.getId());//does ticket exist?
        t.setPrice(100000.50264);
        t = tr.mergeTicket(t);
        assertEquals(new Double(100000.50264), t.getPrice());
    }
}
