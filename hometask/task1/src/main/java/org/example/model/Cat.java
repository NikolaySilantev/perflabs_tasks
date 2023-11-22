package org.example.model;

public class Cat extends Animal {

    public static int counter = 0;

    private final static Integer RUNNING_DISTANCE = 200;
    private final static Integer SWIMMING_DISTANCE = 0;

    public Cat(String name) {
        super(name, RUNNING_DISTANCE, SWIMMING_DISTANCE);
        counter++;
    }
}