package com.realdolmen.tickets.domain;

import javax.persistence.Entity;

/**
 * Created by NQRAZ66 on 22/02/2016.
 */
@Entity
public class InternationalFlight extends Flight{

    private Boolean blacklisted;
    private String regulations;

    public Boolean getBlacklisted() {
        return blacklisted;
    }

    public void setBlacklisted(Boolean blacklisted) {
        this.blacklisted = blacklisted;
    }

    public String getRegulations() {
        return regulations;
    }

    public void setRegulations(String regulations) {
        this.regulations = regulations;
    }

    public InternationalFlight() {

    }

    public InternationalFlight(Boolean blacklisted, String regulations) {

        this.blacklisted = blacklisted;
        this.regulations = regulations;
    }
}
