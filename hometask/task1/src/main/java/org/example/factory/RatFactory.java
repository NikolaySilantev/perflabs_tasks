package org.example.factory;

import org.example.model.Animal;
import org.example.model.Rat;

public class RatFactory implements AnimalFactory {
    @Override
    public Animal create(String name) {
        return new Rat(name);
    }
}
