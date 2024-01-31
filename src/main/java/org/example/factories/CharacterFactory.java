package org.example.factories;

import org.example.Character;
import org.example.enums.Archetype;
import org.example.enums.Rank;

public interface CharacterFactory {
    Character createCharacter(Rank rank);
}