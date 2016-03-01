package com.realdolmen.tickets.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by NQRAZ66 on 22/02/2016.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Flight implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String number;
    private Date departureTime;
    private Date arrivelTime;

    @OneToMany(mappedBy = "flightOut")
    private List<Ticket> ticketsOut;
    @OneToMany(mappedBy = "flightReturn")
    private List<Ticket> ticketsReturn;

    @ManyToMany
    private List<Passenger> passengers;

    @ManyToOne
    private Plane plane;

    public Flight(String number, Date departureTime, Date arrivelTime, List<Ticket> ticketsOut, List<Ticket> ticketsReturn, List<Passenger> passengers, Plane plane) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivelTime = arrivelTime;
        this.ticketsOut = ticketsOut;
        this.ticketsReturn = ticketsReturn;
        this.passengers = passengers;
        this.plane = plane;
    }

    public Flight() {
    }

    public Flight(String number) {
        this.number = number;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Ticket> getTicketsOut() {
        return ticketsOut;
    }

    public void setTicketsOut(List<Ticket> ticketsOut) {
        this.ticketsOut = ticketsOut;
    }

    public List<Ticket> getTicketsReturn() {
        return ticketsReturn;
    }

    public void setTicketsReturn(List<Ticket> ticketsReturn) {
        this.ticketsReturn = ticketsReturn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivelTime() {
        return arrivelTime;
    }

    public void setArrivelTime(Date arrivelTime) {
        this.arrivelTime = arrivelTime;
    }
}
