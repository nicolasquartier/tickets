package com.realdolmen.tickets.beans;

import com.realdolmen.tickets.domain.Person;
import com.realdolmen.tickets.service.PersonServiceBean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class PersonBean {
    @EJB
    private PersonServiceBean personServiceBean;

    public List<Person> getAllPersons() {
        return personServiceBean.findAll();
    }
}
