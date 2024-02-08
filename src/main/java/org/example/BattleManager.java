package org.example;

import org.example.archetypes.GameCharacter;

import java.util.*;

public class BattleManager {
    private Map<UUID, BattleStateMachine> activeBattles;

    public Map<UUID, BattleStateMachine> getActiveBattles() {
        return activeBattles;
    }

    public Map<UUID, BattleStateMachine> getFinishedBattles() {
        return finishedBattles;
    }

    private Map<UUID, BattleStateMachine> finishedBattles;



    private List<GameCharacter> combatants;

    public List<GameCharacter> getCombatants() {
        return combatants;
    }

    public void setCombatants(List<GameCharacter> combatants) {
        this.combatants = combatants;
    }

    public void addCombatants(List<GameCharacter> newCombatants){
        for (GameCharacter newChar:newCombatants) {
            combatants.add(newChar);
        }
    }

    public void removeCombatant(GameCharacter combatant){
        combatants.remove(combatant);
    }

    private void assignBattleID(UUID newBattleID)
    {
        for (GameCharacter combatant:combatants) {
            combatant.setBattleID(newBattleID);
        }
    }



    public BattleManager() {
        this.activeBattles = new HashMap<>();
        this.finishedBattles = new HashMap<>();
    }

    public void createNewBattle(List<GameCharacter> combatants) {
        Battle newBattle = new Battle(combatants);
        UUID battleId = UUID.randomUUID(); // Generate a unique ID for the battle
        BattleStateMachine battleStateMachine = new BattleStateMachine(newBattle, this, battleId);
        activeBattles.put(battleId, battleStateMachine);
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