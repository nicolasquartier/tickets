package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Passenger;
import com.realdolmen.tickets.domain.Ticket;
import org.junit.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by NQRAZ66 on 19/02/2016.
 */
public class PassengerRepositoryTest {

    private static EntityManagerFactory emf;
    private static EntityTransaction tx;
    private static PassengerRepositoryBean pr;

    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory("Test");
        pr = new PassengerRepositoryBean();
    }

    @AfterClass
    public static void closeEntityManager() throws Exception {
        emf.close();
    }

    @Before
    public void initTransaction() {
        pr.em = emf.createEntityManager();
        tx = pr.em.getTransaction();
        tx.begin();

    }

    @After
    public void closeTransation() {
        tx.rollback();
        pr.em.close();
    }

    @Test
    public void shouldSavePassenger() {
        Passenger p = new Passenger("123-456-789", "Nicolas", new Date(0), "Quartier", 1000);
        assertNull("passenger's id must be null", p.getId());
        pr.save(p);
        pr.em.flush();
        assertNotNull("passenger'is should not be null because saved!", p.getId());
    }

    @Test
    public void shouldFindPassengerByid() {
        Passenger p = pr.findPassengerById(3L);
        assertNotNull("passenger should be in table to find", p);
        assertEquals(new Long(3L), p.getId());
        assertEquals("123-456-789", p.getSsn());
    }

    @Test
    public void shouldFindAllPassengers() {
        List<Passenger> list = pr.findAll();
        assertNotNull(list);
        assertEquals(2, list.size());
    }

    @Test
    public void shouldDeletePassenger() {
        Passenger p = pr.findPassengerById(3L);
        assertNotNull("passenger should be in table to find", p);
        pr.delete(p);
        pr.em.flush();
        p = pr.findPassengerById(3L);
        assertNull("Passenger's id must be null", p);
    }

    @Test
    public void shouldUpdatePassenger() {
        Passenger p = pr.findPassengerById(3L);
        assertNotNull("Passenger's id should not be null because saved!", p.getId());//does ticket exist?
        assertEquals(2, p.getVersion());
        p.setLastName("Quartier2");
        p = pr.mergePassenger(p);
        pr.em.flush();
        assertEquals(3, p.getVersion());
        assertEquals("Quartier2", p.getLastName());
    }

    @Test
    public void shouldFindAllLastNames() {
        List<String> list = pr.findAllLastNames();
        assertEquals(2, list.size());
    }

    @Test
    public void shouldCountFrequentFlyerMiles() {
        long milesSum = pr.totalFrequentFlyerMiles();
        assertEquals(3000, milesSum);
    }

    @Test
    public void shouldFindTicketsByPassengerId() {
        List<Ticket> list = pr.findTicketsByPassengerId(3L);

        assertEquals(1, list.size());
    }
}
