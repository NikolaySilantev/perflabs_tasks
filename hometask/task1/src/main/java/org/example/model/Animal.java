package org.example.model;

public abstract class Animal {
    private String name;
    public static int counter = 0;

    private final Integer RunningDistance;
    private final Integer SwimmingDistance;


    public void run (Integer distance) {
        if (distance <= RunningDistance)
            System.out.println(this.getClass().getSimpleName() + " " + name + " ran " + distance + " meters!");
        else if (this.RunningDistance == 0)
            System.out.println(this.getClass().getSimpleName() + " " + name + " can't run.");
        else
            System.out.println(this.getClass().getSimpleName() + " " + name + " ran " + RunningDistance + " and died. ("  + (distance - RunningDistance) + " meters left)");
    }

    public void swim (Integer distance) {
        if (distance <= SwimmingDistance)
            System.out.println(this.getClass().getSimpleName() + " " + name + " swam " + distance + " meters!");
        else if (SwimmingDistance == 0)
            System.out.println(this.getClass().getSimpleName() + " " + name + " can't swim.");
        else
            System.out.println(this.getClass().getSimpleName() + " " + name + " swam " + SwimmingDistance + " and died. (" + (distance - SwimmingDistance) + " meters left)");
    }

    public Animal(String name, Integer RunningDistance, Integer SwimmingDistance) {
        this.name = name;
        this.RunningDistance = RunningDistance;
        this.SwimmingDistance = SwimmingDistance;
        counter++;
    }
}
