package org.example;

import org.example.archetypes.GameCharacter;
import org.example.combat.Battle;
import org.example.combat.BattleManager;
import org.example.enums.TournamentLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TournamentBracket {
    TournamentNode root;
    int numberOfRounds;

    public TournamentLevel getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(TournamentLevel currentRound) {
        this.currentRound = currentRound;
    }

    TournamentLevel currentRound;

    public TournamentBracket(){
        root = new TournamentNode(TournamentLevel.FINAL);
    }

    public TournamentBracket(int numberOfEntrants){
        System.out.println("Making Tournament Tree...");
        numberOfRounds = calculateRoundsRequired(numberOfEntrants);
        System.out.println("Number of ROunds: "+numberOfRounds);
        currentRound = TournamentLevel.FINAL;
        root = new TournamentNode(currentRound);

        for (int i = 1; i < numberOfRounds; i++) {
            this.addLevel();
            currentRound = currentRound.next();
        }
        System.out.println(currentRound);
    }

    private int calculateRoundsRequired(int numberOfEntrants){
        int numberOfBattles = numberOfEntrants/2;


        return (int) (Math.log(numberOfBattles) / Math.log(2)) + 1;
    }


    public void addLevel(){
        List<TournamentNode> allLeaves = getAllLeaves();
        TournamentLevel levelToAdd = allLeaves.get(0).tournamentLevel.next();
        System.out.println("Adding Level ..."+levelToAdd);
        for (TournamentNode node: allLeaves) {
            node.addNodes(levelToAdd);
        }
    }

    public List<TournamentNode> getAllLeaves(){
        List<TournamentNode> allLeaves = new ArrayList<>();
        getAllLeaves(root, allLeaves);
        return allLeaves;
    }

    private void getAllLeaves(TournamentNode node, List<TournamentNode> allLeaves) {
        if (node == null){
            return;
        }
        if (node.leftNode == null && node.rightNode == null){
            allLeaves.add(node);
        }else {
            getAllLeaves(node.leftNode, allLeaves);
            getAllLeaves(node.rightNode, allLeaves);
        }

    }


    public void display() {
        printIndentedTree(root, "");
    }

    private void printIndentedTree(TournamentNode node, String indent) {
        if (node == null) {
            return;
        }

        Battle currentBattle = node.battle;
        if(currentBattle != null)
        {
            if(currentBattle.getVictor() == null) {
                System.out.println(indent + node.tournamentLevel
                        + " -["
                        + currentBattle.getCombatantOne().getCharNameWithClass()
                        + " vs "
                        + currentBattle.getCombatantTwo().getCharNameWithClass()
                        + "]");
            }else{
                System.out.println(indent + node.tournamentLevel
                        + " -[Victor - "
                        + currentBattle.getVictor().getCharNameWithClass() +" - ID: "+ currentBattle.getVictor().getCharID()
                        + "]");
            }
        }
        else {
            System.out.println(indent + node.tournamentLevel);
        }
        printIndentedTree(node.leftNode, indent + "\t");
        printIndentedTree(node.rightNode, indent + "\t");

    }

    public boolean advanceRound(BattleManager battleManager) {
          getVictors(root, battleManager);
          if (currentRound == TournamentLevel.FINAL)
              return false;
          else{
              currentRound = currentRound.previous();
              return true;
          }


    }

    private void getVictors(TournamentNode node, BattleManager battleManager) {
        if(node.battle == null){
            if(node.leftNode.battle == null && node.rightNode.battle == null)
            {
                getVictors(node.leftNode, battleManager);
                getVictors(node.rightNode, battleManager);
            }else{
                List<GameCharacter>victorsFromChildren = new ArrayList<>();
                victorsFromChildren.add(node.leftNode.battle.getVictor());
                victorsFromChildren.add(node.rightNode.battle.getVictor());
                UUID newBattleID = battleManager.generateNewBattleID();
                node.battle = battleManager.createNewBattle(newBattleID, victorsFromChildren);
            }

        }
    }
}
