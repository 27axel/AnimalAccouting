package com.axel.model;

import java.util.Map;

public class Animal {
    private Map<String, String> properties;

    public Animal(Map<String, String> properties) {
        this.properties = properties;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public String getProperty(String property) {
        return properties.get(property);
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
