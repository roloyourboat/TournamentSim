package org.example.factories;

import org.example.Character;
import org.example.archetypes.Mage;
import org.example.archetypes.Ranger;
import org.example.enums.Rank;

public class RangerFactory implements CharacterFactory {

    public Character createCharacter(Rank rank) {
        // Implement logic to create a Ranger character with the specified rank
        return new Ranger(rank);
    }
}
