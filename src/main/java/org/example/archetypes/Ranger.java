package org.example.archetypes;

import org.example.*;
import org.example.enums.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Ranger extends GameCharacter {

    public static final Map<VigorState, Magnitude> DEFAULT_VIGOR_THRESHOLDS = initialiseDefaultVigorThresholds();
    public static final Map<StatName, Stat> DEFAULT_STATS = initialiseDefaultStats();
    public static final CombatMoves ALL_COMBAT_MOVES = initialiseAllCombatMovesList();

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
    private static CombatMoves initialiseAllCombatMovesList() {
        // Read JSON data from a file
        return JsonUtility.getCombatMovesFromJSON("/JSON/RangerCombatMoves.JSON");
    }

    public Ranger(Rank charRank) {
        // Call the constructor of the base class (Character)
        super(charRank, Archetype.RANGER);
        this.charMoves = ALL_COMBAT_MOVES;
        this.mainDefensiveStat = StatName.STURDINESS;


    }

}
