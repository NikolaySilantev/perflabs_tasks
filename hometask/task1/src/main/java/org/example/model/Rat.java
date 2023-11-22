package org.example.model;

public class Rat extends Animal {
    public static int counter = 0;

    private static final Integer RUNNING_DISTANCE = 30;
    private static final Integer SWIMMING_DISTANCE = 10;

    public Rat(String name) {
        super(name, RUNNING_DISTANCE, SWIMMING_DISTANCE);
        counter++;
    }
}
