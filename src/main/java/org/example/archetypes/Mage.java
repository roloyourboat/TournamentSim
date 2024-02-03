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

public class Mage extends Character {

    public static final Map<VigorState, Magnitude> DEFAULT_VIGOR_THRESHOLDS = initialiseDefaultVigorThresholds();
    public static final Map<StatName, Stat> DEFAULT_STATS = initialiseDefaultStats();

    private static Map<VigorState, Magnitude> initialiseDefaultVigorThresholds() {
        Map<VigorState, Magnitude> thresholdsToReturn = new HashMap<>();
        thresholdsToReturn.put(VigorState.UNHARMED, Magnitude.LOW);
        thresholdsToReturn.put(VigorState.SCRATCHED, Magnitude.VERY_HIGH);

        return thresholdsToReturn;
    }
    private static Map<StatName, Stat> initialiseDefaultStats() {
        Map<StatName, Stat> statsToReturn = new HashMap<>();
        // Add default stats here
        statsToReturn.put(StatName.CRAFTINESS, new Stat(StatName.CRAFTINESS, 14.0, Magnitude.HIGH, Magnitude.MODERATE));
        statsToReturn.put(StatName.CAREFULNESS, new Stat(StatName.CAREFULNESS, 22.0, Magnitude.MODERATE, Magnitude.VERY_HIGH));
        // Add other default stats as needed
        return statsToReturn;
    }








    public Mage(Rank charRank) {
        // Call the constructor of the base class (Character)
        super(charRank, Archetype.MAGE);

    }

}
