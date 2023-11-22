package org.example.factory;

import org.example.model.Animal;

public interface AnimalFactory {
    Animal create(String name);
}
