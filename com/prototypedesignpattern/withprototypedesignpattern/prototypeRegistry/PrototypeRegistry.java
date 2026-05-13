package com.prototypedesignpattern.withprototypedesignpattern.prototypeRegistry;

import java.util.HashMap;
import java.util.Map;

// PrototypeRegistry.java
// Stores pre-configured prototypes — clone by name
class PrototypeRegistry {

    private Map<String, StudentProfile> registry = new HashMap<>();

    // Register a prototype with a key
    public void register(String key, StudentProfile profile) {
        registry.put(key, profile);
    }

    // Get a fresh clone by key
    public StudentProfile get(String key) {
        StudentProfile profile = registry.get(key);
        if (profile == null)
            throw new IllegalArgumentException("No prototype found for: " + key);
        return profile.clone();   // always returns a clone — never the original
    }
}