package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Passenger;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by NQRAZ66 on 29/02/2016.
 */
public class PassengerRepositoryTestJNDI {

    private static Context context;
    private static PassengerRepositoryRemote repository;

    @BeforeClass
    public static void setupBeforeClass() throws NamingException {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", true);
        properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        properties.put(Context.PROVIDER_URL, "remote://localhost:4447");
        properties.put(Context.SECURITY_PRINCIPAL, "administrator");
        properties.put(Context.SECURITY_CREDENTIALS, "Azerty123!");
        context = new InitialContext(properties);
        repository = (PassengerRepositoryRemote) context.lookup("ticket-ear-1.0/ticket-ejb/PassengerRepositoryBean!com.realdolmen.tickets.repository.PassengerRepositoryRemote");

    }

    @Test
    public void testFindAllPassengers() throws Exception {
        List<Passenger> all = repository.findAll();
        for (Passenger passenger : all) {
            System.out.println(passenger.getFirstName());
        }
    }

    @Test
    public void shouldFindPassengerByid() throws Exception {
        //PassengerRepositoryRemote repository = (PassengerRepositoryRemote) context.lookup("ticket-ear-1.0/ticket-ejb/PassengerRepositoryBean!com.realdolmen.tickets.repository.PassengerRepositoryRemote");
        Passenger p = repository.findPassengerById(3L);
        assertNotNull("passenger should be in table to find", p);
        assertEquals(new Long(3L), p.getId());
        assertEquals("123-456-789", p.getSsn());
        System.out.println(p.getFirstName());
    }
}
