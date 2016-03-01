package com.realdolmen.tickets.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by NQRAZ66 on 19/02/2016.
 */
@Embeddable
public class Address implements Serializable {

    private String street;
}
