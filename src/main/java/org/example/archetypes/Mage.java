package org.example.archetypes;

import org.example.Character;
import org.example.enums.Archetype;
import org.example.enums.Rank;

public class Mage extends Character {
    public Mage(Rank charRank) {
        // Call the constructor of the base class (Character)
        super(charRank, Archetype.MAGE);

    }

}
