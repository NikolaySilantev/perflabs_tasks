package org.example.model;

public class Tiger extends Animal {
    public static int counter = 0;

    private static final Integer RUNNING_DISTANCE = 1000;
    private static final Integer SWIMMING_DISTANCE = 0;

    public Tiger(String name) {
        super(name, RUNNING_DISTANCE, SWIMMING_DISTANCE);
        counter++;
    }
}
