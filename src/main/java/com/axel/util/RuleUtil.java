package com.axel.util;

import com.axel.model.Animal;
import com.axel.model.Rule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class RuleUtil {
    public List<Rule> loadRules(String filePath) throws IOException {
        List<Rule> rules = new ArrayList<>();
        List<String> lines = Files.readAllLines(Path.of(filePath));
        lines.forEach(line -> rules.add(new Rule(line)));
        return rules;
    }

    public void applyRules(List<Animal> animals, List<Rule> rules) {
        for (Rule rule : rules) {
            int count = 0;
            for (Animal animal : animals) {
                if (matches(animal, rule.getCondition())) {
                    count++;
                }
            }
            System.out.println("Для условия \"" + rule.getCondition() + "\" животных " + count);
        }
    }

    private boolean matches(Animal animal, String condition) {
        String[] orConditions = condition.split(" ИЛИ ");
        for (String orCondition : orConditions) {
            if (matchesAndCondition(animal, orCondition.trim())) {
                return true;
            }
        }
        return false;
    }

    private boolean matchesAndCondition(Animal animal, String condition) {
        String[] andConditions = condition.split(" И ");

        for (String andCondition : andConditions) {
            if (!evaluateCondition(animal, andCondition.trim())) {
                return false;
            }
        }

        return true;
    }

    private boolean evaluateCondition(Animal animal, String condition) {
        if (condition.contains("==")) {
            String[] parts = condition.split("==");
            String property = parts[0].trim();
            String value = parts[1].trim();
            return animal.getProperty(property).equals(value);
        } else if (condition.contains("!=")) {
            String[] parts = condition.split("!=");
            String property = parts[0].trim();
            String value = parts[1].trim();
            return !animal.getProperty(property).equals(value);
        }

        return false;
    }
}
