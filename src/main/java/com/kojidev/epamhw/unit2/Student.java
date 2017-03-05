package com.kojidev.epamhw.unit2;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
class Student implements Person {

    Student() {
        throw new UnsupportedOperationException("Objects requires dependencies");
    }

    private String name;

    Student(String name) {
        this.name = name;
    }

    private List<Product> inventory = new ArrayList<>();

    public void giveItem(Product item) {
        inventory.add(item);
    }

    public List<Product> getItems() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    @Override
    public void trigger(Triggerable item) {
        item.start(this);
    }
}
