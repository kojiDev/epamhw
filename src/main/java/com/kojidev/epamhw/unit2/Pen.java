package com.kojidev.epamhw.unit2;

/**
 * Vanilla Java class with manually overridden methods {@code equals}, {@code hashCode}, {@code toString},
 * getters and setters.
 *
 * @author stan
 */
public class Pen implements Product {

    private final Brand brand;
    private final int price;

    Pen() {
        throw new UnsupportedOperationException("Objects requires dependencies");
    }

    Pen(Brand brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public Brand getBrand() {
        return brand;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        return
                brand.equals(pen.brand);
    }

    @Override
    public int hashCode() {

        if (brand == null)
            return 0;

        int num = 17;
        return
                31 * num + brand.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" + hashCode() + "[" +
                "brand=" + brand.getName() + "," +
                "price=" + price +
                "]";
    }
}
