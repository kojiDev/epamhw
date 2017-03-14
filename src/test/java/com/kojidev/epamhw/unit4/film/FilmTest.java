package com.kojidev.epamhw.unit4.film;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static junit.framework.Assert.assertEquals;

public class FilmTest {

    @Test
    public void test() throws IOException, ClassNotFoundException {

        FilmCollection fc = new FilmCollection("Films with Eva Green");

        Film f1 = new Film("Miss Peregrine's Home for Peculiar Children");
        Film f2 = new Film("300: Rise of an Empire");

        Actor eva = new Actor("Eva Green");
        Actor asa = new Actor("Asa Butterfield");
        Actor sul = new Actor("Sullivan Stapleton");

        f1.addActor(eva);
        f1.addActor(asa);

        f2.addActor(eva);
        f2.addActor(sul);

        fc.addFilm(f1);
        fc.addFilm(f2);

        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("src/main/resources/unit4/serialization_output.bin"))
        ) {
            oos.writeObject(fc);
        }

        FilmCollection copy = FilmCollection.load("src/main/resources/unit4/serialization_output.bin");

        assertEquals(fc, copy);

    }

}
