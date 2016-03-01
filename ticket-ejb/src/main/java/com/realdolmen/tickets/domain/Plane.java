package com.realdolmen.tickets.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by NQRAZ66 on 22/02/2016.
 */
@Entity
public class Plane implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
