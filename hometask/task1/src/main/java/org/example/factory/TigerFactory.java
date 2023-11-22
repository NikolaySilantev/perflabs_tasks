package org.example.factory;

import org.example.model.Animal;
import org.example.model.Tiger;

public class TigerFactory implements AnimalFactory {
    @Override
    public Animal create(String name) {
        return new Tiger(name);
    }
}
