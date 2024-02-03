package org.example.archetypes;

import org.example.*;
import org.example.Character;
import org.example.enums.Archetype;
import org.example.enums.Rank;
import org.example.enums.StatName;
import org.example.enums.VigorState;

import java.util.HashMap;
import java.util.Map;

public class Warrior extends Character {

    // Additional attributes specific to warriors
    public static final Map<VigorState, Magnitude> DEFAULT_VIGOR_THRESHOLDS = initialiseDefaultVigorThresholds();
    public static final Map<StatName, Stat> DEFAULT_STATS = initialiseDefaultStats();

    private static Map<VigorState, Magnitude> initialiseDefaultVigorThresholds() {
        Map<VigorState, Magnitude> thresholdsToReturn = new HashMap<>();
        thresholdsToReturn.put(VigorState.UNHARMED, Magnitude.HIGH);
        thresholdsToReturn.put(VigorState.SCRATCHED, Magnitude.LOW);

        return thresholdsToReturn;
    }
    private static Map<StatName, Stat> initialiseDefaultStats() {
        Map<StatName, Stat> statsToReturn = new HashMap<>();
        // TODO read stats from JSON
        statsToReturn.put(StatName.DEADLINESS, new Stat(StatName.DEADLINESS, 14.0, Magnitude.LOW, Magnitude.MODERATE));
        statsToReturn.put(StatName.STURDINESS, new Stat(StatName.STURDINESS, 30.0, Magnitude.HIGH, Magnitude.LOW));
        // Add other default stats as needed
        return statsToReturn;
    }


    private int shieldStrength;

    public Warrior(Rank charRank) {
        // Call the constructor of the base class (Character)
        super(charRank, Archetype.WARRIOR);
        // Initialize charVigor with default thresholds

        // Initialize warrior-specific attributes
        this.shieldStrength = 100; // You can set an initial value
    }

    // Additional methods specific to warriors
    public void blockAttack() {
        // Implement logic for blocking attacks with the shield
        // You can use shieldStrength and other warrior-specific attributes here
    }

}
