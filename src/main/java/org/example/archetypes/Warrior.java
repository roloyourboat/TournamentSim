package org.example.archetypes;

import org.example.*;
import org.example.enums.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Warrior extends GameCharacter {

    // Additional attributes specific to warriors
    public static final Map<VigorState, Magnitude> DEFAULT_VIGOR_THRESHOLDS = initialiseDefaultVigorThresholds();
    public static final Map<StatName, Stat> DEFAULT_STATS = initialiseDefaultStats();
    public static final CombatMoves ALL_COMBAT_MOVES = initialiseAllCombatMovesList();



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
        statsToReturn.put(StatName.STURDINESS, new Stat(StatName.STURDINESS, 25.0, Magnitude.HIGH, Magnitude.LOW));
        // Add other default stats as needed
        return statsToReturn;
    }

    private static CombatMoves initialiseAllCombatMovesList() {
        // Read JSON data from a file
        return JsonUtility.getCombatMovesFromJSON("/JSON/WarriorCombatMoves.JSON");
    }




    private int shieldStrength;

    public Warrior(Rank charRank) {
        // Call the constructor of the base class (Character)
        super(charRank, Archetype.WARRIOR);
        // Initialize charVigor with default thresholds
        this.charMoves = ALL_COMBAT_MOVES;
        this.mainDefensiveStat = StatName.STURDINESS;

        // Initialize warrior-specific attributes
        this.shieldStrength = 100; // You can set an initial value
    }

    // Additional methods specific to warriors
    public void blockAttack() {
        // Implement logic for blocking attacks with the shield
        // You can use shieldStrength and other warrior-specific attributes here
    }

}
