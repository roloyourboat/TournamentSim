package org.example.enums;

import java.util.Random;

public enum Archetype {
    WARRIOR,
    MAGE,
    THIEF,
    RANGER;

    private static final Random random = new Random();

    // Method to randomly assign an archetype
    public static Archetype getRandomArchetype() {
        return values()[random.nextInt(values().length)];
    }
}
