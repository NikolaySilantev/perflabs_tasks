package org.example.factory;

import org.example.model.Animal;
import org.example.model.Dog;

public class DogFactory implements AnimalFactory {
    @Override
    public Animal create(String name) {
        return new Dog(name);
    }
}
