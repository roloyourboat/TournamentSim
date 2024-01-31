package org.example;

import org.example.enums.StatName;

/**
 * Class representing a character's stat with specific values.
 */
public class Stat {
    private StatName name;
    private double baseValue;
    private Magnitude proficiencyMagnitude;
    private Magnitude varianceMagnitude;

    /**
     * Constructs a new Stat with the specified name, base value, and magnitudes.
     *
     * @param name               The name of the stat.
     * @param baseValue          The base value of the stat.
     * @param proficiencyMagnitude The magnitude of proficiency affecting the stat.
     * @param varianceMagnitude   The magnitude of variance affecting the stat.
     */
    public Stat(StatName name, double baseValue, Magnitude proficiencyMagnitude, Magnitude varianceMagnitude) {
        this.name = name;
        this.baseValue = baseValue;
        this.proficiencyMagnitude = proficiencyMagnitude;
        this.varianceMagnitude = varianceMagnitude;
    }

    /**
     * Gets the name of the stat.
     *
     * @return The name of the stat.
     */
    public StatName getName() {
        return name;
    }

    /**
     * Gets the base value of the stat.
     *
     * @return The base value of the stat.
     */
    public double getBaseValue() {
        return baseValue;
    }

    /**
     * Gets the magnitude of proficiency affecting the stat.
     *
     * @return The magnitude of proficiency affecting the stat.
     */
    public Magnitude getProficiencyMagnitude() {
        return proficiencyMagnitude;
    }

    /**
     * Sets the magnitude of proficiency affecting the stat.
     *
     * @param proficiencyMagnitude The magnitude of proficiency affecting the stat.
     */
    public void setProficiencyMagnitude(Magnitude proficiencyMagnitude) {
        this.proficiencyMagnitude = proficiencyMagnitude;
    }

    /**
     * Gets the magnitude of variance affecting the stat.
     *
     * @return The magnitude of variance affecting the stat.
     */
    public Magnitude getVarianceMagnitude() {
        return varianceMagnitude;
    }

    /**
     * Sets the magnitude of variance affecting the stat.
     *
     * @param varianceMagnitude The magnitude of variance affecting the stat.
     */
    public void setVarianceMagnitude(Magnitude varianceMagnitude) {
        this.varianceMagnitude = varianceMagnitude;
    }

    /**
     * Returns a string representation of the stat in the format "Name: Base Value".
     *
     * @return A string representation of the stat.
     */
    @Override
    public String toString() {
        return name + ": " + baseValue;
    }
}
