package com.realdolmen.tickets.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by NQRAZ66 on 19/02/2016.
 */
@Embeddable
public class EmployeeId implements Serializable{

    private String ssn;
    private String lastName;

    public EmployeeId(String ssn, String lastName) {
        this.ssn = ssn;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeId that = (EmployeeId) o;

        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (ssn != null ? !ssn.equals(that.ssn) : that.ssn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ssn != null ? ssn.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    public EmployeeId() {
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
