package com.kojidev.epamhw.unit2;

class Car {

    final Engine engine;

    public class Engine implements Triggerable {

        private boolean isActive;

        @Override
        public void start(Person person) {
            System.out.println("Brmrmrmrmrmmr..");
            isActive = true;
        }
    }

    Car() {
        engine = new Engine();
    }

}
