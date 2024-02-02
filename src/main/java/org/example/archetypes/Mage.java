package org.example.archetypes;

import org.example.Character;
import org.example.Magnitude;
import org.example.enums.Archetype;
import org.example.enums.Rank;
import org.example.enums.VigorState;

import java.util.HashMap;
import java.util.Map;

public class Mage extends Character {

    public static final Map<VigorState, Magnitude> DEFAULT_VIGOR_THRESHOLDS;

    static {
        DEFAULT_VIGOR_THRESHOLDS = new HashMap<>();
        DEFAULT_VIGOR_THRESHOLDS.put(VigorState.UNHARMED, Magnitude.LOW);
        DEFAULT_VIGOR_THRESHOLDS.put(VigorState.SCRATCHED, Magnitude.VERY_HIGH);
        // Define other thresholds for the Mage archetype
    }
    public Mage(Rank charRank) {
        // Call the constructor of the base class (Character)
        super(charRank, Archetype.MAGE);

    }

}
