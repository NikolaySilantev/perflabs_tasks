package org.example;

import org.example.factory.*;
import org.example.model.Animal;

import java.util.*;

public class Main
{
    private final static int MAX_DISTANCE = 1000;
    private final static int MIN_DISTANCE = 1;
    private final static int MAX_EACH_ANIMAL_COUNT = 3;
    private final static int MIN_EACH_ANIMAL_COUNT = 1;
    private final static String[] NAMES = new String[] {
            "Crococar", "Woreesaasi", "Gireesreakeo",
            "Neelorb", "Neaxoth", "Slootsealing",
            "Sreekomingo", "Gesreapsi", "Xamsaa",
            "Octadger", "Hyenopus", "Hexafaune",
            "Palsucsa", "Falepleo", "Beavoozoodee",
            "Gaadamel", "Soukerpillar", "Likrilla",
            "Keatsmingo","Poupeex","Defsoomee",
            "Skuney", "Pandoose"
    };

    public static void main( String[] args )
    {
        AnimalFactory[] factories = new AnimalFactory[] {
                new CatFactory(),
                new DogFactory(),
                new RatFactory(),
                new SharkFactory(),
                new TigerFactory()
        };

        Random r = new Random();
        List<Animal> animals = new ArrayList<>();

        // For random animal's name
        List<String> shuffledNamesList = Arrays.asList(NAMES);
        Collections.shuffle(shuffledNamesList);

        for (AnimalFactory factory: factories
             ) {
            int animalCount = r.nextInt(MIN_EACH_ANIMAL_COUNT, MAX_EACH_ANIMAL_COUNT + 1);
            for (int i = 0; i < animalCount; i++)
                animals.add(factory.create(shuffledNamesList.get(Animal.counter % NAMES.length)));
        }

        int distance = r.nextInt(MIN_DISTANCE,MAX_DISTANCE + 1);

        for (Animal animal:animals
             ) {
            animal.run(distance);
            animal.swim(distance);
        }

        System.out.println("Total number of animals: " + Animal.counter);
    }
}
