package org.example;

import org.example.Status;
import org.example.enums.Magnitude;
import org.example.enums.MoveType;
import org.example.enums.StatName;

import java.util.Arrays;

/**
 * Represents a combat move in the game.
 */
public class CombatMove {
    private String moveName;
    private MoveType moveType;
    private StatName mainStat;
    private StatName secondaryStat;
    private Magnitude fallibility;
    private Magnitude perfection;
    private Status[] gainStatus;
    private Status[] giveStatus;

    /**
     * Constructs a new combat move with the specified attributes.
     *
     * @param moveType       The type of the combat move (e.g., attack, defend).
     * @param mainStat       The main stat associated with the move.
     * @param secondaryStat  The secondary stat associated with the move.
     * @param fallibility    The magnitude of fallibility for the move.
     * @param perfection     The magnitude of perfection for the move.
     * @param gainStatus     The statuses gained when using the move.
     * @param giveStatus     The statuses given to the opponent when using the move.
     */
    public CombatMove(String moveName, MoveType moveType, StatName mainStat, StatName secondaryStat,
                      Magnitude fallibility, Magnitude perfection,
                      Status[] gainStatus, Status[] giveStatus) {
        this.moveName = moveName;
        this.moveType = moveType;
        this.mainStat = mainStat;
        this.secondaryStat = secondaryStat;
        this.fallibility = fallibility;
        this.perfection = perfection;
        this.gainStatus = gainStatus;
        this.giveStatus = giveStatus;
    }

    /**
     * Gets the type of the combat move.
     *
     * @return The move type.
     */
    public MoveType getMoveType() {
        return moveType;
    }

    /**
     * Gets the main stat associated with the move.
     *
     * @return The main stat.
     */
    public StatName getMainStat() {
        return mainStat;
    }

    /**
     * Gets the secondary stat associated with the move.
     *
     * @return The secondary stat.
     */
    public StatName getSecondaryStat() {
        return secondaryStat;
    }

    /**
     * Gets the magnitude of fallibility for the move.
     *
     * @return The fallibility magnitude.
     */
    public Magnitude getFallibility() {
        return fallibility;
    }

    /**
     * Gets the magnitude of perfection for the move.
     *
     * @return The perfection magnitude.
     */
    public Magnitude getPerfection() {
        return perfection;
    }

    /**
     * Gets the statuses gained when using the move.
     *
     * @return An array of gained statuses.
     */
    public Status[] getGainStatus() {
        return gainStatus;
    }

    /**
     * Gets the statuses given to the opponent when using the move.
     *
     * @return An array of given statuses.
     */
    public Status[] getGiveStatus() {
        return giveStatus;
    }

    /**
     * Returns a string representation of the combat move.
     *
     * @return A string representing the combat move.
     */
    @Override
    public String toString() {
        return "CombatMove{" +
                "moveName=" + moveName +
                ", moveType=" + moveType +
                ", mainStat=" + mainStat +
                ", secondaryStat=" + secondaryStat +
                ", fallibility=" + fallibility +
                ", perfection=" + perfection +
                ", gainStatus=" + Arrays.toString(gainStatus) +
                ", giveStatus=" + Arrays.toString(giveStatus) +
                '}';
    }

    public String getMoveName() {
        return moveName;
    }

    public void setMoveName(String moveName) {
        this.moveName = moveName;
    }
}
