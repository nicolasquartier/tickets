package com.realdolmen.tickets.domain;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by NQRAZ66 on 22/02/2016.
 */
@Entity
public class DomesticFlight extends Flight{

    private String airlineCompany;
    @ElementCollection
    private List<String> refs;



    public String getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(String airlineCompany) {
        this.airlineCompany = airlineCompany;
    }

    public List<String> getRefs() {
        return refs;
    }

    public void setRefs(List<String> refs) {
        this.refs = refs;
    }

    public DomesticFlight() {

    }

    public DomesticFlight(String airlineCompany, List<String> refs) {

        this.airlineCompany = airlineCompany;
        this.refs = refs;
    }
}
