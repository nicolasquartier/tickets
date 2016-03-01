package com.realdolmen.tickets.service;

import com.realdolmen.tickets.domain.Person;
import com.realdolmen.tickets.repository.PersonRepositoryRemote;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class PersonServiceIntegrationTest extends AbstractJndiTest {

    @Test
    @Ignore
    public void testPersonServiceCanBeAccessedRemotely() throws Exception {
        PersonRepositoryRemote personRepository = lookup("ticket-ear-1.0/ticket-ejb-1.0/PersonRepositoryBean!com.realdolmen.tickets.repository.PersonRepository");
        System.out.println(personRepository);
        for (Person person : personRepository.findAll()) {
            System.out.println(person.getFirstName() + " " + person.getLastName());
        }

    }
}
