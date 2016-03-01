package com.realdolmen.tickets.repository;

import com.realdolmen.tickets.domain.Employee;
import com.realdolmen.tickets.domain.EmployeeId;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by NQRAZ66 on 19/02/2016.
 */
@Stateless
@LocalBean
public class EmployeeRepositoryBean {
    @PersistenceContext
    EntityManager em;


    public Employee save(Employee e) {
        em.persist(e);
        return e;
    }

    public Employee findEmployee(EmployeeId id) {
        return em.find(Employee.class, id);
    }

    public List<Employee> findEmployeeList() {
        return em.createQuery("select e from Employee e", Employee.class).getResultList();
    }

}
