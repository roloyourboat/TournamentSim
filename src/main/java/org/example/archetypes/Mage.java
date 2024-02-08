package org.example.archetypes;

import org.example.*;
import org.example.combat.CombatMoves;
import org.example.enums.*;

import java.util.HashMap;
import java.util.Map;

public class Mage extends GameCharacter {

    public static final Map<VigorState, Magnitude> DEFAULT_VIGOR_THRESHOLDS = initialiseDefaultVigorThresholds();
    public static final Map<StatName, Stat> DEFAULT_STATS = initialiseDefaultStats();
    public static final CombatMoves ALL_COMBAT_MOVES = initialiseAllCombatMovesList();

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
    private static CombatMoves initialiseAllCombatMovesList() {
        // Read JSON data from a file
        return JsonUtility.getCombatMovesFromJSON("/JSON/MageCombatMoves.JSON");
    }

    public Mage(Rank charRank) {
        // Call the constructor of the base class (Character)
        super(charRank, Archetype.MAGE);
        this.charMoves = ALL_COMBAT_MOVES;
        this.mainDefensiveStat = StatName.STURDINESS;

    }

}
