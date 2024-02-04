package org.example.factories;

import org.example.archetypes.Character;
import org.example.archetypes.Mage;
import org.example.enums.Rank;

public class MageFactory implements CharacterFactory {

    public Character createCharacter(Rank rank) {
        // Implement logic to create a Warrior character with the specified rank
        return new Mage(rank);
    }
}
