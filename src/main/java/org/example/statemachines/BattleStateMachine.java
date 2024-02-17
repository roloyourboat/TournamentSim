package org.example.statemachines;

import org.example.CombatMove;
import org.example.Constants;
import org.example.UI.UIOutputPlaceholder;
import org.example.archetypes.GameCharacter;
import org.example.combat.Battle;
import org.example.combat.BattleManager;
import org.example.combat.CombatCalculator;
import org.example.enums.BattleState;
import org.example.enums.Magnitude;
import org.example.enums.VigorState;

import java.util.UUID;

public class BattleStateMachine {
    private BattleState currentState;

    public Battle getBattle() {
        return battle;
    }

    private Battle battle;


    private BattleManager battleManager;


    private UUID battleId;



    private String battleStatus;


    public BattleStateMachine(Battle battle, BattleManager manager, UUID id) {
        this.currentState = BattleState.INITIALISING_BATTLE;
        this.battle = battle;
        this.battleManager = manager;
        this.battleId = id;
        this.battleStatus = Constants.ACTIVE_BATTLE_STATUS;
        // Initialize the battle
    }

    public void transitionTo(BattleState nextState) {
        // Example of handling specific transitions
        currentState = nextState;
        switch (nextState) {
            case INITIALISING_BATTLE:
                initialisingBattle();
                break;
            case ENDING_BATTLE:
                endingBattle();
                break;
            case COMBATANT_ONE:
                takeTurn(battle.getCombatantOne());
                break;
            case COMBATANT_TWO:
                takeTurn(battle.getCombatantTwo());
                break;
            case VICTORY:
                // Handle victory conditions
                break;
            case DEFEAT:
                // Handle defeat conditions
                break;
            case OPPORTUNITY:
                // Handle special opportunities
                break;
            case STATUS_CONDITIONS:
                // Apply or check status conditions
                break;
            case PAUSED:
                // Handle the battle being paused
                break;
            case GETTING_INPUT:
                // Handle input from the player or AI
                break;
            case TRANSITIONING:
                // Handle transitions between states
                break;
            case DRAW:
                drawingBattle();
                break;
            default:
                // Optionally, handle any cases not explicitly handled above
                break;
        }

    }

    private void endingBattle() {
        GameCharacter victor = battle.getCurrentCharTurn();
        battle.setVictor(victor);
        UIOutputPlaceholder.printToScreen("Victory to "+victor.getCharName()+ " the "+victor.getCharClass());
        addBattleIDtoCombatantsHistory();
        battle.setBattleResult("Decisive");


        this.battleStatus = Constants.COMPLETED_BATTLE_STATUS;

    }

    private void drawingBattle(){
        UIOutputPlaceholder.printToScreen("Stalemate, battle ending as a draw.");
        battle.setBattleResult("Draw");
        addBattleIDtoCombatantsHistory();
//TODO Drawing curenntly breaks the bracket, will resolve later
        GameCharacter victor = battle.getCurrentCharTurn();
        battle.setVictor(victor);
        this.battleStatus = Constants.COMPLETED_BATTLE_STATUS;
    }

    private void initialisingBattle() {
        //Set turn order
        System.out.println("Initialising Battle");
        assignBattleIDtoCombatants();
        transitionTo(BattleState.COMBATANT_ONE);

    }

    private void assignBattleIDtoCombatants() {

        battle.getCombatantOne().setBattleID(battleId);
        battle.getCombatantTwo().setBattleID(battleId);

    }

    private void addBattleIDtoCombatantsHistory(){
        battle.getCombatantOne().addPreviousBattleID(battleId);
        battle.getCombatantTwo().addPreviousBattleID(battleId);
    }

    private void takeTurn(GameCharacter gameCharacter){
        battle.increaseTurnNumber();
        System.out.println("Turn Count: "+battle.getTurnNumber());
        battle.setCurrentChar(gameCharacter);
        //checkStatus()
        //selectAttack()
        CombatMove combatMove = gameCharacter.getCombatMoves().getMoves().get(0);

        //selectTarget
        GameCharacter attackTarget = battle.getOpponent();

        performAttack(gameCharacter, attackTarget, combatMove);

        checkVigorLevels(gameCharacter, attackTarget);

        checkForDraw(gameCharacter, attackTarget, battle.getTurnNumber());

        endTurn();
    }

    private void checkForDraw(GameCharacter gameCharacter, GameCharacter attackTarget, int turnNumber) {
        if((gameCharacter.getCharVigor().getCurrentVigorState() == (VigorState.UNHARMED)
                || attackTarget.getCharVigor().getCurrentVigorState() == (VigorState.UNHARMED))
                        && turnNumber > 100){
            currentState = BattleState.DRAW;
        }

    }

    private void checkVigorLevels(GameCharacter gameCharacter, GameCharacter attackTarget) {
        if(gameCharacter.getCharVigor().getCurrentVigorState() == (VigorState.DEFEATED)
        || attackTarget.getCharVigor().getCurrentVigorState() == (VigorState.DEFEATED)){
            transitionTo(BattleState.ENDING_BATTLE);
        }

    }

    private void endTurn() {
        switch (currentState) {
            case COMBATANT_ONE -> transitionTo(BattleState.COMBATANT_TWO);
            case COMBATANT_TWO -> transitionTo(BattleState.COMBATANT_ONE);
            case DRAW -> transitionTo(BattleState.DRAW);
        }
    }

    private void performAttack(GameCharacter attacker,GameCharacter defender, CombatMove combatMove) {

        Magnitude potentialImpact = CombatCalculator.calculatePotentialImpact(attacker, defender, combatMove);
        CombatCalculator.applyDamage(potentialImpact, defender);

    }

    public void update() {
            // Update and process logic based on the current state
            switch (currentState) {
                case INITIALISING_BATTLE:
                    initialisingBattle();
                    break;
                case ENDING_BATTLE:
                    // Clean up after the battle
                    break;
                case COMBATANT_ONE:
                    // Handle combatant one's turn
                    break;
                case COMBATANT_TWO:
                    // Handle combatant two's turn
                    break;
                case VICTORY:
                    // Handle victory conditions
                    break;
                case DEFEAT:
                    // Handle defeat conditions
                    break;
                case OPPORTUNITY:
                    // Handle special opportunities
                    break;
                case STATUS_CONDITIONS:
                    // Apply or check status conditions
                    break;
                case PAUSED:
                    // Handle the battle being paused
                    break;
                case GETTING_INPUT:
                    // Handle input from the player or AI
                    break;
                case TRANSITIONING:
                    // Handle transitions between states
                    break;
                default:
                    // Optionally, handle any cases not explicitly handled above
                    break;
            }
        }

    public boolean isBattleOver() {
        if (battleStatus.equals(Constants.COMPLETED_BATTLE_STATUS))
            return true;
        else
            return false;
    }

    public UUID getBattleId() {
        return battleId;
    }

}