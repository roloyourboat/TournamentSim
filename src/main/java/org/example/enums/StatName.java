package org.example.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration representing different stats in the game.
 */
public enum StatName {
    DEADLINESS,
    STURDINESS,
    RECKLESSNESS,
    CAREFULNESS,
    AWARENESS,
    CRAFTINESS,
    LUCKINESS;


    // Create a map to store the opposite relationships
    private static final Map<StatName, StatName> OPPOSITE_MAP = new HashMap<>();

    // Initialize the map with the opposite relationships
    static {
        OPPOSITE_MAP.put(STURDINESS, DEADLINESS);
        OPPOSITE_MAP.put(DEADLINESS, STURDINESS);
        OPPOSITE_MAP.put(RECKLESSNESS, CAREFULNESS);
        OPPOSITE_MAP.put(CAREFULNESS, RECKLESSNESS);
        OPPOSITE_MAP.put(AWARENESS, CRAFTINESS);
        OPPOSITE_MAP.put(CRAFTINESS, AWARENESS);
    }

    // Method to get the opposite stat
    public static StatName getOpposite(StatName stat) {
        return OPPOSITE_MAP.get(stat);
    }
}