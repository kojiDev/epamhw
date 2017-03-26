package com.kojidev.epamhw.unit7.wait;

import java.util.Random;

public class IntegerSetterGetter extends Thread {

    private final SharedResource resource;
    private boolean run;
    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource) {
        super(name);
        this.resource = resource;
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;

        try {
            while (run) {
                action = rand.nextInt(1000);
                if (action % 2 == 0) {
                    getIntegersFromResource();
                } else {
                    setIntegersIntoResource();
                }
            }

            System.out.println("Thread: " + getName() + " has finished the work");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void getIntegersFromResource() throws InterruptedException {

        Integer number;

        synchronized (resource) {

            System.out.println("Thread: " + getName() + " wants to extract a number");

            number = resource.getELement();

            for (int i = 0; number == null && i < 5; i++) {
                System.out.println("Thread: " + getName() + " is waiting for queue to be filled");

                resource.wait(100);

                System.out.println("Thread: " + getName() + " has continued the work");

                number = resource.getELement();
            }

            if (number != null) {
                System.out.println("Thread: " + getName() + " extracted the number: " + number);
            }


        }

    }

    private void setIntegersIntoResource() throws InterruptedException {

        Integer number = rand.nextInt(500);

        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Thread: " + getName() + " wrote a number: " + number);
            resource.notify();
        }

    }
}
