package org.example.enums;

import java.util.Random;

public enum Archetype {
    WARRIOR,
    MAGE,
    THIEF,
    RANGER
    ;

    private static final Random random = new Random();

    // Method to randomly assign an archetype
    public static Archetype getRandomArchetype() {
        return values()[random.nextInt(values().length)];
    }

    public String enumToClassName() {
        String lowerCase = this.name().toLowerCase();
        return Character.toUpperCase(lowerCase.charAt(0)) + lowerCase.substring(1);
    }
}
