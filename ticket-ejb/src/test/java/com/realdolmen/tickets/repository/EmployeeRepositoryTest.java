package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Employee;
import com.realdolmen.tickets.domain.EmployeeId;
import org.junit.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by NQRAZ66 on 19/02/2016.
 */
public class EmployeeRepositoryTest {

    private static EntityManagerFactory emf;
    private static EntityTransaction tx;
    private static EmployeeRepositoryBean pr;

    @BeforeClass
    public static void initEntityManager() throws Exception {
        emf = Persistence.createEntityManagerFactory("Test");
        pr = new EmployeeRepositoryBean();
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
        EmployeeId id = new EmployeeId("123-456-789", "Quartier");
        Employee p = new Employee(id, "Nicolas", 1000);
        assertNotNull("passenger should be in table to find", p);
        pr.save(p);
        assertNotNull("passenger'is should not be null because saved!", p.getId());
    }

    @Test
    public void shouldFindPassengerByd() {
        EmployeeId id = new EmployeeId("123-456-789", "Quartier");
        Employee e = pr.findEmployee(id);
        assertNotNull("passenger should be in table to find", e);
        assertEquals(new EmployeeId("123-456-789", "Quartier"), e.getId());
        assertEquals("123-456-789", e.getId().getSsn());
    }

    @Test
    public void shouldFindAllPassengers() {
        List<Employee> list = pr.findEmployeeList();
        assertNotNull(list);
        assertEquals(2, list.size());
    }
}
