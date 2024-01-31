package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CombatMoves {
    // Define attributes to store combat moves
    private List<CombatMove> moveset;

    public CombatMoves() {
        // Initialize the list to store combat moves
        moveset = new ArrayList<>();
    }

    public void addMove(String moveName, int deadliness, int sturdiness, int luckiness) {
        // Method to add a new combat move to the character's moveset
        CombatMove newMove = new CombatMove();
        moveset.add(newMove);
    }

    public void performMove(String moveName, Character source, Character target) {
        // Method to perform a combat move on a target character
        CombatMove move = findMoveByName(moveName);

        if (move != null) {
            // Calculate the effectiveness of the move based on stats
            int damageDealt = calculateDamage(move, source, target);
            //target.takeDamage(damageDealt);
            //System.out.println(source.getName() + " used " + move.getName() + " on " + target.getName() + " for " + damageDealt + " damage.");
        } else {
            System.out.println("Move not found in moveset.");
        }
    }

    private CombatMove findMoveByName(String moveName) {
        // Helper method to find a move by its name
        for (CombatMove move : moveset) {
            //if (move.getName().equalsIgnoreCase(moveName))
            {
                return move;
            }
        }
        return null; // Move not found
    }

    private int calculateDamage(CombatMove move, Character source, Character target) {
        // Helper method to calculate damage based on move and character stats
        //int damage = (move.getDeadliness() - target.getSturdiness()) + source.getLuckiness();
       // return Math.max(damage, 0); // Ensure damage is non-negative
        return 0;
    }
}
