package com.realdolmen.tickets.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by NQRAZ66 on 19/02/2016.
 */
@Entity
public class Passenger implements Serializable {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, updatable = false)
    private String ssn;
    @Column(length = 50)
    private String firstName;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, updatable = false)
    private Date dateOfBirth;
    @Column(length = 50)
    private String lastName;
    private Integer frequantFlyerMiles;
    @Transient
    private int age;
    @Enumerated(EnumType.STRING)
    private PassengerType pt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastFlight;
    @Embedded
    private Address a;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets;

    @Version
    private long version;

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Address getA() {
        return a;
    }

    public void setA(Address a) {
        this.a = a;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }




    public Passenger(String ssn, String firstName, Date dateOfBirth, String lastName, Integer frequantFlyerMiles) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.dateOfBirth = dateOfBirth;
        this.lastName = lastName;
        this.frequantFlyerMiles = frequantFlyerMiles;
    }

    /**
     * used by JPA
     * zo private mogelijk zetten (ma niet gwn private)
     * default is 'privater' dan protected...
     */
    Passenger() {
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PassengerType getPt() {
        return pt;
    }

    public void setPt(PassengerType pt) {
        this.pt = pt;
    }

    public Date getLastFlight() {
        return lastFlight;
    }

    public void setLastFlight(Date lastFlight) {
        this.lastFlight = lastFlight;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFrequantFlyerMiles() {
        return frequantFlyerMiles;
    }

    public void setFrequantFlyerMiles(Integer frequantFlyerMiles) {
        this.frequantFlyerMiles = frequantFlyerMiles;
    }
}
