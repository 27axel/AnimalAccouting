package com.axel.util;

import com.axel.model.Animal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalLoader {
    public List<Animal> loadAnimals(String filePath) throws IOException {
        List<Animal> animals = new ArrayList<>();
        List<String> lines = Files.readAllLines(Path.of(filePath));

        for (String line : lines) {
            String[] props = line.split(",");
            Map<String, String> animalProps = new HashMap<>();
            animalProps.put("ВЕС", props[0]);
            animalProps.put("РОСТ", props[1]);
            animalProps.put("ТИП", props[2]);
            animals.add(new Animal(animalProps));
        }

        return animals;
    }
}
