package com.kojidev.epamhw.unit4.film;

import java.util.HashSet;

public class FilmTest {

    public void test() {

        FilmCollection fc = new FilmCollection("Films with Eva Green");

        Film f1 = new Film("Miss Peregrine's Home for Peculiar Children");
        Film f2 = new Film("300: Rise of an Empire");

        fc.addFilm(f1);
        fc.addFilm(f2);

        Actor eva = new Actor("Eva Green");
        Actor asa = new Actor("Asa Butterfield");
        Actor sul = new Actor("Sullivan Stapleton");

        f1.addActor(eva);
        f1.addActor(asa);

        f2.addActor(eva);
        f2.addActor(sul);

    }

}
