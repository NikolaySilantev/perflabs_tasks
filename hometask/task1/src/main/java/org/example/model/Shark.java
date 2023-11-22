package org.example.model;

public class Shark extends Animal {
    public static int counter = 0;
    private static final Integer RUNNING_DISTANCE = 0;
    private static final Integer SWIMMING_DISTANCE = 1000;

    public Shark(String name) {
        super(name, RUNNING_DISTANCE, SWIMMING_DISTANCE);
        counter++;
    }
}
