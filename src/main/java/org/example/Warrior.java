package org.example;

public class Warrior extends Character {

    // Additional attributes specific to warriors
    private int shieldStrength;

    public Warrior(Rank charRank) {
        // Call the constructor of the base class (Character)
        super(charRank, Archetype.WARRIOR);

        // Initialize warrior-specific attributes
        this.shieldStrength = 100; // You can set an initial value
    }

    // Additional methods specific to warriors
    public void blockAttack() {
        // Implement logic for blocking attacks with the shield
        // You can use shieldStrength and other warrior-specific attributes here
    }

}
