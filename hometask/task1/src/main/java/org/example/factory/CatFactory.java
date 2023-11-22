package org.example.factory;

import org.example.model.Animal;
import org.example.model.Cat;

public class CatFactory implements AnimalFactory {
    @Override
    public Animal create(String name) {
        return new Cat(name);
    }
}
