package com.kojidev.epamhw.unit2;

class AutomaticPen extends Pen {

    AutomaticPen(Brand brand, int price) {
        super(brand, price);
    }

    void toggle() {
        System.out.println("*Click*");
    }
}
