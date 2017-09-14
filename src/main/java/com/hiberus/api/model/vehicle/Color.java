package com.hiberus.api.model.vehicle;

import javax.persistence.*;

/**
 * Created by Daniel Pardo Ligorred.
 */
@Entity(name = "color")
@Table(name = "color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}