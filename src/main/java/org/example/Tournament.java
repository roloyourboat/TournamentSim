package org.example;


import org.example.UI.UIInputPlaceholder;
import org.example.combat.Battle;
import org.example.combat.BattleManager;
import org.example.enums.Rank;
import org.example.events.CharacterCreationEvent;
import org.example.events.GameEvent;
import org.example.events.GameEventDispatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
Class that will manage a tournament of battles
Functionality required
Accept input to determine size of the bracket (also accept rank/archetoye)
Create a sructure to hold the tournmanet (some kind of tree)
Assigne players/battles to the tournament
Visually display the bracket

 */
public class Tournament {

    private static GameEventDispatcher eventDispatcher;
    private final BattleManager battleManager;
    private CharacterManager charManager;
    private List<UUID> battleIDS;
    private UUID tournamentID;
    private boolean tournamentFinished = false;

    public TournamentBracket getTournamentBracket() {
        return tournament;
    }

    private TournamentBracket tournament;



    public static void setEventDispatcher(GameEventDispatcher dispatcher) {
        eventDispatcher = dispatcher;
    }
    public Tournament(CharacterManager charManager, BattleManager battleManager, int numOfCombatants, Rank rank) {
        this.tournamentID = UUID.randomUUID();
        this.charManager = charManager;
        this.battleManager = battleManager;
        this.battleIDS = new ArrayList<>();
        // get/create the characters
        GameEvent.dispatchEvent(new CharacterCreationEvent(charManager, Rank.NOVICE,numOfCombatants));
        // Create the tree
        createEmptyBracket(numOfCombatants);
        // Assign chars to the leaf nodes
        assignCharsToBattles(numOfCombatants);

    }

    private void assignCharsToBattles(int numOfCombatants) {
        List<TournamentNode> allLeaves = tournament.getAllLeaves();
        for (TournamentNode leafNode:allLeaves) {
            UUID newBattleID = battleManager.generateNewBattleID();
            battleIDS.add(newBattleID);
            Battle newBattle = battleManager.createNewBattle(newBattleID);
            leafNode.battle = newBattle;
        }
    }

    private void createEmptyBracket(int numOfCombatants){
        int currentNumberOfLeaves = 0;
        tournament = new TournamentBracket(numOfCombatants);
        tournament.display();

    }

    public void display(){
        tournament.display();
    }

    public void advanceRound() {
        // Prompt to Advance
        //UIInputPlaceholder.getStringFromInput("Advance to Next Round?");
            boolean canAdvance = tournament.advanceRound(battleManager);
            if(!canAdvance)
                tournamentFinished = true;


    }

    public boolean isTournamentFinished() {
        return tournamentFinished;
    }
}
