package org.example.enums;

public enum Rank {
    NOVICE,
    JOURNEYMAN,
    EXPERT,
    MASTER,
    LEGENDARY;

    // Method to increase rank by one level
    public Rank increaseRank() {
        // Get the ordinal value of the current rank
        int currentRankOrdinal = this.ordinal();

        // Get the next rank if it's within the enum
        if (currentRankOrdinal < values().length - 1) {
            return values()[currentRankOrdinal + 1];
        } else {
            // If the current rank is already the highest, return the same rank
            return this;
        }
    }
}
