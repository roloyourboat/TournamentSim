package org.example.combat;

import org.example.CharacterManager;
import org.example.archetypes.GameCharacter;
import org.example.events.GameEventDispatcher;
import org.example.statemachines.BattleStateMachine;

import java.util.*;

public class BattleManager {
    private CharacterManager charManager;
    private static GameEventDispatcher eventDispatcher;

    public static void setEventDispatcher(GameEventDispatcher dispatcher) {
        eventDispatcher = dispatcher;
    }
    private Map<UUID, BattleStateMachine> activeBattles;

    public Map<UUID, BattleStateMachine> getActiveBattles() {
        return activeBattles;
    }

    public Map<UUID, BattleStateMachine> getFinishedBattles() {
        return finishedBattles;
    }

    private Map<UUID, BattleStateMachine> finishedBattles;


    public BattleManager(CharacterManager charManager) {
        this.activeBattles = new HashMap<>();
        this.finishedBattles = new HashMap<>();
        this.charManager = charManager;
    }

    public UUID generateNewBattleID(){
        return UUID.randomUUID();
    }

    public Battle createNewBattle(UUID battleId) {

        Battle newBattle = new Battle(battleId, charManager.getUnassignedChars(2));
        BattleStateMachine battleStateMachine = new BattleStateMachine(newBattle, this, battleId);
        activeBattles.put(battleId, battleStateMachine);

        return newBattle;
    }
    public Battle createNewBattle(UUID battleId, List<GameCharacter> battleParticipants) {
        Battle newBattle = new Battle(battleId, battleParticipants);
        BattleStateMachine battleStateMachine = new BattleStateMachine(newBattle, this, battleId);
        activeBattles.put(battleId, battleStateMachine);

        return newBattle;
    }


    public BattleStateMachine getBattle(UUID battleId) {
        return activeBattles.get(battleId);
    }

    public void endBattle(UUID battleId) {
        activeBattles.remove(battleId);
    }

    // Call this method to update all battles
    public void updateAllBattles() {
        Iterator<Map.Entry<UUID, BattleStateMachine>> iterator = activeBattles.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<UUID, BattleStateMachine> entry = iterator.next();
            BattleStateMachine battleStateMachine = entry.getValue();
            battleStateMachine.update();
            if (battleStateMachine.isBattleOver())
            {
                // remove from activeBattles and send to private Map<UUID, BattleStateMachine> finishedBattles;
                iterator.remove();
                
                finishedBattles.put(battleStateMachine.getBattleId(), battleStateMachine);
            }


        }
    }

    // Method to display previous battle results
    public void displayPreviousResults() {
        for (Map.Entry<UUID, BattleStateMachine> entry : finishedBattles.entrySet()) {
            Battle battle = entry.getValue().getBattle();
            System.out.println("Battle ID: " + entry.getKey());
            System.out.println("Combatants: " + battle.getCombatantOne().getCharNameWithClass()
                    + " vs " + battle.getCombatantTwo().getCharNameWithClass());
            System.out.println("Status: " + battle.getBattleResult());
            if(battle.getBattleResult().equals("Decisive"))
                System.out.println("Victor: "+battle.getVictor().getCharNameWithClass());
            System.out.println("Final Turn Count: " + battle.getTurnNumber());
            System.out.println(); // Blank line for readability
        }
    }

    public boolean areBattlesFinished() {
        return activeBattles.isEmpty();
    }

    // Additional methods as needed, e.g., for updating all battles
}