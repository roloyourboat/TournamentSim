package org.example.factories;

import org.example.archetypes.Character;
import org.example.archetypes.Warrior;
import org.example.enums.Rank;

public class WarriorFactory implements CharacterFactory {
    @Override
    public Character createCharacter(Rank rank) {
        // Implement logic to create a Warrior character with the specified rank
        return new Warrior(rank);
    }
}