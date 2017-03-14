package com.kojidev.epamhw.unit4.film;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
public class Actor implements Serializable {

    private final String name;

    public Actor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
