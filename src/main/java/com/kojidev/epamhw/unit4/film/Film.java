package com.kojidev.epamhw.unit4.film;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
public class Film implements Serializable {

    private final Set<Actor> actors = new HashSet<>();
    private final String title;

    public Film(String title) {
        this.title = title;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public String getTitle() {
        return title;
    }
}
