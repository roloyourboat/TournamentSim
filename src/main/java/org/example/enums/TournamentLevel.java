package org.example.enums;

public enum TournamentLevel {
        FINAL,
        SEMI,
        QUARTER,
        LAST_SIXTEEN;

        public TournamentLevel next() {
                // Check if this is the last element
                if (this.ordinal() == TournamentLevel.values().length - 1) {
                        System.out.println("No more levels.");
                        return null; // or this, if you want to cycle
                }
                return TournamentLevel.values()[this.ordinal() + 1];
        }

        public TournamentLevel previous() {
                // Check if this is the last element
                if (this.ordinal() == 0) {
                        System.out.println("No more levels.");
                        return null; // or this, if you want to cycle
                }
                return TournamentLevel.values()[this.ordinal() - 1];
        }



}
