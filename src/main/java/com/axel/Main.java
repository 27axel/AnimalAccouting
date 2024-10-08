package com.axel;

import com.axel.model.Animal;
import com.axel.model.Rule;
import com.axel.util.AnimalLoader;
import com.axel.util.RuleUtil;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        AnimalLoader animalLoader = new AnimalLoader();
        List<Animal> animals = animalLoader.loadAnimals("animals.txt");
        RuleUtil rule = new RuleUtil();
        List<Rule> rules = rule.loadRules("rules.txt");
        rule.applyRules(animals, rules);
    }
}