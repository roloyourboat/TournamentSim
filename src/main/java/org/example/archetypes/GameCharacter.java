package org.example.archetypes;

import org.example.*;
import org.example.enums.Archetype;
import org.example.enums.Rank;
import org.example.enums.StatName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class GameCharacter {




    protected UUID battleID;

    public UUID getCharID() {
        return charID;
    }

    public void setCharID(UUID charID) {
        this.charID = charID;
    }

    public Rank getCharRank() {
        return charRank;
    }

    protected UUID charID;
    private List<UUID> previousBattleIDs = new ArrayList<>();
    private String charName;
    protected Archetype charClass;

    public String getCharNameWithClass() {
        return charNameWithClass;
    }

    private String charNameWithClass;
    private Rank charRank;
    protected StatName mainDefensiveStat;
    private Stats charStats;
    protected CombatMoves charMoves;

    protected Vigor charVigor;
    protected Momentum charMomentum;
    protected Desperation charDesperation;

    protected GameCharacter(Rank charRank){
        charClass = Archetype.getRandomArchetype();
        this.charName = generateRandomName(charClass);
        this.charRank = charRank;
        this.charStats = new Stats(this.charRank, this.charClass);
        this.charMoves = new CombatMoves();
        this.charVigor = Vigor.getDefaultVigor(charClass);
        this.charNameWithClass = charName + " the " +charClass.enumToClassName();
        this.charID = UUID.randomUUID();

    }

    protected GameCharacter(Rank charRank, Archetype archetype){
        this.charClass = archetype;
        this.charName = generateRandomName(charClass);
        this.charRank = charRank;
        this.charStats = new Stats(this.charRank, this.charClass);
        this.charMoves = new CombatMoves();
        this.charVigor = Vigor.getDefaultVigor(charClass);
        this.charNameWithClass = charName + " the " +charClass.enumToClassName();
        this.charID = UUID.randomUUID();
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
    public String getCharName() {
        return charName;
    }
    public Archetype getCharClass() {
        return charClass;
    }

    public Stats getCharStats() {
        return charStats;
    }

    public Stat getCharStat(StatName statName)
    {
        return  charStats.getStat(statName);
    }

    public void setCharStats(Stats charStats) {
        this.charStats = charStats;
    }

    public StatName getMainDefensiveStat() {
        return mainDefensiveStat;
    }

    public void setMainDefensiveStat(StatName mainDefensiveStat) {
        this.mainDefensiveStat = mainDefensiveStat;
    }

    public CombatMoves getCombatMoves(){
        return charMoves;
    }

    public UUID getBattleID() {
        return battleID;
    }

    public void setBattleID(UUID battleID) {
        this.battleID = battleID;
    }

    public List<UUID> getPreviousBattleIDs() {
        return previousBattleIDs;
    }

    public void setPreviousBattleIDs(List<UUID> previousBattleIDs) {
        this.previousBattleIDs = previousBattleIDs;
    }
    public void addPreviousBattleID(UUID battleID) {
        if (battleID != null && !previousBattleIDs.contains(battleID)) {
            previousBattleIDs.add(battleID);
        }
    }

    public Vigor getCharVigor() {
        return charVigor;
    }
    public void setCharVigor(Vigor charVigor) {
        this.charVigor = charVigor;
    }



    @Override
    public String toString() {
        return "Character Information:" +
                "\nName: " + charName +
                "\nClass: " + charClass +
                "\nRank: " + charRank +
                printStats(false)+
                "\nVigor: " + charVigor +
      //          "\nMomentum: " + charMomentum +
      //          "\nDesperation: " + charDesperation +
                printMoves(false);
    }

    private String printStats(Boolean print){
        if (print)
            return "\nStats: " + charStats;
        else
            return "";
    }

    private String printMoves(Boolean print){
        if (print)
            return "\nMoves: " + charMoves;
        else
            return "";
    }



}
