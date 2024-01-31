package org.example.factories;

import org.example.Character;
import org.example.archetypes.Mage;
import org.example.enums.Rank;
import org.example.factories.CharacterFactory;

public class MageFactory implements CharacterFactory {

    public Character createCharacter(Rank rank) {
        // Implement logic to create a Warrior character with the specified rank
        return new Mage(rank);
    }
}
