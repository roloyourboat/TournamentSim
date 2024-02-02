package org.example.factories;

import org.example.Character;
import org.example.archetypes.Mage;
import org.example.archetypes.Thief;
import org.example.enums.Rank;

public class ThiefFactory implements CharacterFactory {

    public Character createCharacter(Rank rank) {
        // Implement logic to create a Thief character with the specified rank
        return new Thief(rank);
    }
}
