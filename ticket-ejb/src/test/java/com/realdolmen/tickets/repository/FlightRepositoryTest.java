package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.DomesticFlight;
import com.realdolmen.tickets.domain.Flight;
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
 * Created by NQRAZ66 on 22/02/2016.
 */
public class FlightRepositoryTest {

    private static EntityManagerFactory emf;
    private static EntityTransaction tx;
    private static FlightRepositoryBean fr;

    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory("Test");
        fr = new FlightRepositoryBean();
    }

    @AfterClass
    public static void closeEntityManager() throws Exception {
        emf.close();
    }

    @Before
    public void initTransaction() {
        fr.em = emf.createEntityManager();
        tx = fr.em.getTransaction();
        tx.begin();

    }

    @After
    public void closeTransation() {
        tx.rollback();
        fr.em.close();
    }

    @Test
    public void shouldSaveFlight() {
        Flight fOut = new Flight("123");

        assertNull("Flight's id must be null", fOut.getId());

        fr.save(fOut);
        fr.em.flush();
        assertNotNull("Flight's id should not be null because saved!", fOut.getId());
    }

    @Test
    public void shouldFindFlightByid() {
        DomesticFlight f = fr.findByIdDomestic(1L);
        assertNotNull("DomesticFlight should be in table to find", f);
        assertEquals(new Long(1L), f.getId());
        //assertEquals(200.0, t.getPrice());
    }

    @Test
    public void shouldFindAllFlights() {
        List<DomesticFlight> list = fr.findAllDomesticFlights();
        assertNotNull(list);
        assertEquals(2, list.size());
    }
}
