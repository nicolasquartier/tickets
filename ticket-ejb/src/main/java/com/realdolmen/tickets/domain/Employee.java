package com.realdolmen.tickets.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by NQRAZ66 on 19/02/2016.
 */
@Entity
public class Employee  implements Serializable {
    @EmbeddedId
    private EmployeeId id;
    private String firstName;
    private Integer frequantFlyerMiles;

    public Employee() {
    }

    public Employee(EmployeeId id, String firstName, Integer frequantFlyerMiles) {
        this.id = id;
        this.firstName = firstName;
        this.frequantFlyerMiles = frequantFlyerMiles;
    }

    public EmployeeId getId() {
        return id;
    }

    public void setId(EmployeeId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getFrequantFlyerMiles() {
        return frequantFlyerMiles;
    }

    public void setFrequantFlyerMiles(Integer frequantFlyerMiles) {
        this.frequantFlyerMiles = frequantFlyerMiles;
    }
}
