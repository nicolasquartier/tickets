package com.realdolmen.tickets.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by NQRAZ66 on 22/02/2016.
 */
@Entity
public class Ticket implements Serializable {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Flight flightOut;
    @ManyToOne
    private Flight flightReturn;

    public Ticket(Double price, Passenger passenger, Flight flightOut, Flight flightReturn) {
        this.price = price;
        this.passenger = passenger;
        this.flightOut = flightOut;
        this.flightReturn = flightReturn;
    }

    public Ticket() {
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlightOut() {
        return flightOut;
    }

    public void setFlightOut(Flight flightOut) {
        this.flightOut = flightOut;
    }

    public Flight getFlightReturn() {
        return flightReturn;
    }

    public void setFlightReturn(Flight flightReturn) {
        this.flightReturn = flightReturn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
