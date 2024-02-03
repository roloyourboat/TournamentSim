package org.example.archetypes;

import org.example.Character;
import org.example.Magnitude;
import org.example.Stat;
import org.example.enums.Archetype;
import org.example.enums.Rank;
import org.example.enums.StatName;
import org.example.enums.VigorState;

import java.util.HashMap;
import java.util.Map;

public class Ranger extends Character {

    public static final Map<VigorState, Magnitude> DEFAULT_VIGOR_THRESHOLDS = initialiseDefaultVigorThresholds();
    public static final Map<StatName, Stat> DEFAULT_STATS = initialiseDefaultStats();

    private static Map<VigorState, Magnitude> initialiseDefaultVigorThresholds() {
        Map<VigorState, Magnitude> thresholdsToReturn = new HashMap<>();
        thresholdsToReturn.put(VigorState.SCRATCHED, Magnitude.VERY_LOW);
        thresholdsToReturn.put(VigorState.CRITICAL, Magnitude.VERY_LOW);

        return thresholdsToReturn;
    }
    private static Map<StatName, Stat> initialiseDefaultStats() {
        Map<StatName, Stat> statsToReturn = new HashMap<>();
        // Add default stats here
        statsToReturn.put(StatName.DEADLINESS, new Stat(StatName.DEADLINESS, 35.0, Magnitude.VERY_HIGH, Magnitude.MODERATE));
        statsToReturn.put(StatName.AWARENESS, new Stat(StatName.AWARENESS, 17.0, Magnitude.HIGH, Magnitude.LOW));
        // Add other default stats as needed
        return statsToReturn;
    }

    public Ranger(Rank charRank) {
        // Call the constructor of the base class (Character)
        super(charRank, Archetype.RANGER);

    }

}
