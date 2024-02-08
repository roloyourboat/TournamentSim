package org.example.enums;

public enum BattleState {
        INITIALISING_BATTLE,
        ENDING_BATTLE,
        COMBATANT_ONE,
        COMBATANT_TWO,
        VICTORY,
        DEFEAT,
        OPPORTUNITY,
        STATUS_CONDITIONS,
        PAUSED,
        GETTING_INPUT,
        TRANSITIONING,
        DRAW


        /*
        INITIALISING_BATTLE: Set up the battle environment, initialize combatants, and prepare any necessary UI elements.
        COMBATANT_ONE and COMBATANT_TWO: Implement turn-based logic here. This could involve allowing the player to choose actions for their character and determining the actions of the enemy (which could be AI-controlled).
        VICTORY and DEFEAT: Define what happens when the battle ends, such as updating the game state, awarding experience points or loot, and transitioning back to the main game flow.
        OPPORTUNITY: Handle special cases or random events that can occur during battle, like critical hits or special moves.
        STATUS_CONDITIONS: Apply or update any status effects on combatants, such as poison or paralysis.
        PAUSED: Implement pause functionality, allowing players to take a break or access in-game menus.
        GETTING_INPUT: Manage the collection of player inputs for making decisions during their turn.
        TRANSITIONING: Handle transitions between states smoothly, ensuring that the game UI and internal state are updated appropriately.
         */

}
