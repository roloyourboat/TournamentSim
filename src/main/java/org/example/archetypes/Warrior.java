package org.example.archetypes;

import org.example.Character;
import org.example.Magnitude;
import org.example.Vigor;
import org.example.enums.Archetype;
import org.example.enums.Rank;
import org.example.enums.VigorState;

import java.util.HashMap;
import java.util.Map;

public class Warrior extends Character {

    // Additional attributes specific to warriors
    public static final Map<VigorState, Magnitude> DEFAULT_VIGOR_THRESHOLDS;

    static {
        DEFAULT_VIGOR_THRESHOLDS = new HashMap<>();
        DEFAULT_VIGOR_THRESHOLDS.put(VigorState.UNHARMED, Magnitude.HIGH);
        DEFAULT_VIGOR_THRESHOLDS.put(VigorState.SCRATCHED, Magnitude.LOW);
        // Define other thresholds for the Warrior archetype
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
