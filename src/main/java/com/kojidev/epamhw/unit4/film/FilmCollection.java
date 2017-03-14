package com.kojidev.epamhw.unit4.film;

import lombok.EqualsAndHashCode;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode
public class FilmCollection implements Serializable {

    private final String title;
    private Set<Film> data = new HashSet<>();

    public FilmCollection(String title) {

        this.title = title;
    }

    public static FilmCollection load(String dump) throws IOException, ClassNotFoundException {

        FilmCollection collection;

        try (ObjectInputStream ois
                     = new ObjectInputStream(new FileInputStream(dump))) {
            collection = (FilmCollection) ois.readObject();
        }

        return collection;
    }

    public void addFilm(Film film) {
        data.add(film);
    }

    public String getTitle() {
        return title;
    }

    public Set<Film> getFilms() {
        return data;
    }
}
