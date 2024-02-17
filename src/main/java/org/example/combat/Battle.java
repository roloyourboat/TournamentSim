package org.example.combat;

import org.example.archetypes.GameCharacter; // Assuming GameCharacter is your character class
import org.example.combat.CombatCalculator;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

public class Battle {

    private GameCharacter combatantOne;
    private GameCharacter combatantTwo;


    private GameCharacter currentCharTurn;
    private String environment; // Example of additional info, like "forest" or "dungeon"
    private List<String> specialConditions; // Conditions that might affect the battle, e.g., "nighttime", "fog"


    private CombatCalculator combatCalculator;
    private int turnNumber;


    private String battleResult;
    private GameCharacter victor;

    public UUID getBattleID() {
        return battleID;
    }

    private UUID battleID;


    // Constructor
    public Battle(UUID battleID,List<GameCharacter> combatants) {
        //TODO decide who goes first
        this.combatantOne = combatants.get(0);
        this.combatantTwo = combatants.get(1);
        this.battleID = battleID;

        combatantOne.setBattleID(battleID);
        combatantTwo.setBattleID(battleID);

        //Make sure Health is full
        combatantOne.getCharVigor().resetVigor();
        combatantTwo.getCharVigor().resetVigor();

        this.turnNumber = 0;
        this.combatCalculator = new CombatCalculator();

    }
    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }
    public void increaseTurnNumber() {
        this.turnNumber++;
    }

    public CombatCalculator getCombatCalculator() {
        return combatCalculator;
    }

    public void setCombatCalculator(CombatCalculator combatCalculator) {
        this.combatCalculator = combatCalculator;
    }

    public GameCharacter getCurrentCharTurn() {
        return currentCharTurn;
    }

    public void setCurrentChar(GameCharacter currentTurn) {
        this.currentCharTurn = currentTurn;
    }



    // Methods to add or remove special conditions
    public void addSpecialCondition(String condition) {
        specialConditions.add(condition);
    }

    public void removeSpecialCondition(String condition) {
        specialConditions.remove(condition);
    }

    // Getters and Setters
    public GameCharacter getCombatantOne() {
        return combatantOne;
    }

    public void setCombatantOne(GameCharacter combatantOne) {
        this.combatantOne = combatantOne;
    }

    public GameCharacter getCombatantTwo() {
        return combatantTwo;
    }

    public void setCombatantTwo(GameCharacter combatantTwo) {
        this.combatantTwo = combatantTwo;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public List<String> getSpecialConditions() {
        return new ArrayList<>(specialConditions); // Return a copy to prevent external modification
    }


    public String getBattleResult() {
        return battleResult;
    }

    public void setBattleResult(String battleResult) {
        this.battleResult = battleResult;
    }

    public GameCharacter getVictor() {
        return victor;
    }

    public void setVictor(GameCharacter victor) {
        this.victor = victor;
    }

    public GameCharacter getOpponent() {
        if (currentCharTurn == combatantOne)
            return combatantTwo;
        else
            return combatantOne;
    }
}
