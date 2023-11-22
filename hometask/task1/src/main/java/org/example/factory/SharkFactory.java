package org.example.factory;

import org.example.model.Animal;
import org.example.model.Shark;

public class SharkFactory implements AnimalFactory {
    @Override
    public Animal create(String name) {
        return new Shark(name);
    }
}
