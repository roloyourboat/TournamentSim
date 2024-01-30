package org.example;

import java.util.HashMap;
import java.util.Random;

public class Character {

    private String charName;
    protected Archetype charClass;
    private Rank charRank;
    private Stats charStats;
    protected CombatMoves charMoves;

    private Vigor charVigor;
    protected Momentum charMomentum;
    protected Desperation charDesperation;

    protected Character(Rank charRank){
        this.charClass = Archetype.getRandomArchetype();
        this.charName = generateRandomName(charClass);
        this.charRank = charRank;
        this.charStats = new Stats(this.charRank, this.charClass);
        this.charMoves = new CombatMoves();

    }

    protected Character(Rank charRank, Archetype archetype){
        this.charClass = archetype;
        this.charName = generateRandomName(charClass);
        this.charRank = charRank;
        this.charStats = new Stats(this.charRank, this.charClass);
        this.charMoves = new CombatMoves();

    }

    private String generateRandomName(Archetype charClass) {
        // Define arrays of names for each archetype
        String[] warriorNames = {"Aldric", "Siegfried", "Valeria", "Thrain"};
        String[] mageNames = {"Elowen", "Cedric", "Lorelei", "Sorin"};
        String[] thiefNames = {"Raven", "Lysandra", "Kellen", "Silas"};
        String[] rangerNames = {"Elden", "Aria", "Branwen", "Faelan"};

        // Use a switch statement to select the appropriate name list based on the archetype
        switch (charClass) {
            case WARRIOR:
                return getRandomName(warriorNames);
            case MAGE:
                return getRandomName(mageNames);
            case THIEF:
                return getRandomName(thiefNames);
            case RANGER:
                return getRandomName(rangerNames);
            default:
                return "Unknown"; // Handle unknown archetype
        }
    }

    // Method to select a random name from an array of names
    private String getRandomName(String[] names) {
        int randomIndex = new Random().nextInt(names.length);
        return names[randomIndex];
    }

    @Override
    public String toString() {
        return "Character Information:" +
                "\nName: " + charName +
                "\nClass: " + charClass +
                "\nRank: " + charRank +
                "\nStats: " + charStats +
                "\nVigor: " + charVigor +
                "\nMomentum: " + charMomentum +
                "\nDesperation: " + charDesperation +
                "\nMoves: " + charMoves;
    }


}
