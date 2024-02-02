package org.example;

import org.example.enums.Comparison;

public enum Magnitude {
    NONE,
    VERY_LOW,
    LOW,
    MODERATE,
    HIGH,
    VERY_HIGH,
    MAXIMUM;

    public Comparison compare(Magnitude magnitudeToCompareTo) {
        int magnitudeDifference = this.ordinal() - magnitudeToCompareTo.ordinal();

        if (magnitudeDifference < 0) {
            return Comparison.LESS_THAN;
        } else if (magnitudeDifference == 0) {
            return Comparison.EQUAL;
        } else {
            return Comparison.GREATER_THAN;
        }
    }

    public int getDifference(Magnitude magnitudeToCompareTo){
        return this.ordinal() - magnitudeToCompareTo.ordinal();
    }

}