package org.example.enums;

public enum VigorState {
    UNHARMED,
    SCRATCHED,
    WOUNDED,
    INJURED,
    CRITICAL,
    DEFEATED;

    public VigorState reduceVigorState() {
        VigorState[] states = VigorState.values();
        int currentIndex = this.ordinal();
//        System.out.println("States: "+states);
//        System.out.println("Curretn ordinal" +currentIndex);

        if (currentIndex < 5) {
 //           System.out.println("Vigor moving");
            return states[currentIndex + 1];
        } else {
            System.out.println("cancel");
            return this; // Already at the lowest state
        }
    }

    public Comparison compare(VigorState vigorStateToCompareTo) {
        int vigorStateDifference = this.ordinal() - vigorStateToCompareTo.ordinal();

        if (vigorStateDifference < 0) {
            return Comparison.LESS_THAN;
        } else if (vigorStateDifference == 0) {
            return Comparison.EQUAL;
        } else {
            return Comparison.GREATER_THAN;
        }
    }

    public String enumToClassName() {
        String lowerCase = this.name().toLowerCase();
        return Character.toUpperCase(lowerCase.charAt(0)) + lowerCase.substring(1);
    }
}