package org.example.archetypes;

import org.example.*;
import org.example.combat.CombatMoves;
import org.example.enums.*;

import java.util.HashMap;
import java.util.Map;

public class Thief extends GameCharacter {

    public static final Map<VigorState, Magnitude> DEFAULT_VIGOR_THRESHOLDS = initialiseDefaultVigorThresholds();
    public static final Map<StatName, Stat> DEFAULT_STATS = initialiseDefaultStats();
    public static final CombatMoves ALL_COMBAT_MOVES = initialiseAllCombatMovesList();

    private static Map<VigorState, Magnitude> initialiseDefaultVigorThresholds() {
        Map<VigorState, Magnitude> thresholdsToReturn = new HashMap<>();
        thresholdsToReturn.put(VigorState.UNHARMED, Magnitude.VERY_LOW);
        thresholdsToReturn.put(VigorState.WOUNDED, Magnitude.MAXIMUM);

        return thresholdsToReturn;
    }
    private static Map<StatName, Stat> initialiseDefaultStats() {
        Map<StatName, Stat> statsToReturn = new HashMap<>();
        // Add default stats here
        statsToReturn.put(StatName.DEADLINESS, new Stat(StatName.DEADLINESS, 37.0, Magnitude.VERY_HIGH, Magnitude.MODERATE));
        statsToReturn.put(StatName.LUCKINESS, new Stat(StatName.LUCKINESS, 22.0, Magnitude.HIGH, Magnitude.MAXIMUM));
        // Add other default stats as needed
        return statsToReturn;
    }
    private static CombatMoves initialiseAllCombatMovesList() {
        // Read JSON data from a file
        return JsonUtility.getCombatMovesFromJSON("/JSON/ThiefCombatMoves.JSON");
    }

    public Thief(Rank charRank) {
        // Call the constructor of the base class (Character)
        super(charRank, Archetype.THIEF);
        this.charMoves = ALL_COMBAT_MOVES;
        this.mainDefensiveStat = StatName.STURDINESS;

    }

}
