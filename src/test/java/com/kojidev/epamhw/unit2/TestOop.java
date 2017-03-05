package com.kojidev.epamhw.unit2;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.Assert.assertEquals;

public class TestOop {

    @Test
    public void test() {

        Student ivan = new Student("Ivan");
        ExchangeStudent mike = new ExchangeStudent("Mike");

        Pen pen1 = new Pen(new Brand("Parker"), 21000);
        Pen pen2 = new AutomaticPen(new Brand("Waterman"), 10000);
        Pen pen3 = new Pen(new Brand("Avanzo"), 15000);

        Pen pen4 = new Pen(new Brand("Lenso"), 5000);
        Pen pen5 = new AutomaticPen(new Brand("Parker"), 11000);

        ivan.giveItem(pen1);
        ivan.giveItem(pen2);
        ivan.giveItem(pen3);

        mike.giveItem(pen4);
        mike.giveItem(pen5);

        System.out.println(pen1);
        System.out.println(pen2);

        AutomaticPen automaticPen = (AutomaticPen) pen2;
        automaticPen.toggle();

        Course<Student> course = new Course<>("Math", GradeSystem.FIVE);
        course.add(ivan);

        Course<ExchangeStudent> courseRussian = new Course<>("Russian Language", GradeSystem.TEN);
        courseRussian.add(mike);

        Car car = new Car();
        ivan.trigger(car.engine);

        List<Product> sorted = ivan.getItems().stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .sorted(Comparator.comparing(a -> a.getBrand().getName()))
                .collect(Collectors.toList());

        System.out.println("\nSorted list of pens: ");

        assertEquals(sorted.get(0),pen3);
        assertEquals(sorted.get(1),pen1);
        assertEquals(sorted.get(2),pen2);
    }

}
