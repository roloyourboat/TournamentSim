package org.example.enums;

public enum Magnitude {
    NONE(0.0),
    VERY_LOW(0.1),
    LOW(0.3),
    MODERATE(0.7),
    HIGH(0.9),
    VERY_HIGH(0.99),
    MAXIMUM(1);

    public double getUpperPercentageThreshold() {
        return upperPercentageThreshold;
    }

    private final double upperPercentageThreshold;

    Magnitude(double upperPercentageThreshold) {
        this.upperPercentageThreshold = upperPercentageThreshold;
    }

    public static Magnitude getMagnitudeFromPercentage(double percentage) {
        for (Magnitude magnitude : values()) {
            if (percentage <= magnitude.upperPercentageThreshold) {
                return magnitude;
            }
        }

        // If percentage is greater than the highest threshold, return MAXIMUM
        return MAXIMUM;
    }

    public static Magnitude reduceMagnitude(Magnitude currentThreshold) {
        int currentOrdinal = currentThreshold.ordinal();
//        System.out.println("This Mag red: "+currentThreshold);
//        System.out.println("This Mag red ord: "+currentThreshold.ordinal());

        // Check if the current magnitude is not the lowest (NONE)
        if (currentOrdinal > 0) {
//            System.out.println("Reducing Magnitude from "+currentThreshold+" to "+values()[currentOrdinal - 1]);
            // Return the magnitude one step lower
            return values()[currentOrdinal - 1];
        } else {
            // If it's already the lowest, return NONE (you can choose another default if needed)
            return NONE;
        }
    }

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
//        System.out.println("This Mag: "+this);
//        System.out.println("This Mag ord: "+this.ordinal());
//        System.out.println("Compare Mag: "+magnitudeToCompareTo);
//        System.out.println("Compare Mag ord: "+magnitudeToCompareTo.ordinal());
        return Math.abs(this.ordinal() - magnitudeToCompareTo.ordinal());
    }

}