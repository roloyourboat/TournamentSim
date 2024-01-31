package org.example;

import org.example.enums.MoveType;

import java.util.Map;

public class CombatMove {

    /**
     * String for the name of the CombatMove
     */
    private String name;

    /**
     * Magnitude to represent potential damage of CombatMove
     */
    private Magnitude potentialImpact;

    /**
     * Enum MoveType to indicate the type of move (offensive, defensive etc.)
      */
    private MoveType moveType;

    /**
     * Map of Stat and a Double
     * Represents a multiplier for each Stat when used by this CombatMove
     */
    private Map<Stat,Double> statModifiers;

    /**
     *
     */
    private Magnitude fallibility;

    /**
     *
     */

    private Magnitude perfection;

    public CombatMove() {


    }


}
