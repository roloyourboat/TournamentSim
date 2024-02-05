package org.example;

 import org.example.archetypes.Character;
 import org.example.enums.Archetype;
 import org.example.enums.Rank;
 import org.example.factories.CharacterFactory;  // Import your CharacterFactory interface

import java.lang.reflect.Constructor;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

public class CharacterGenerator {
        public CharacterGenerator() {
        }

    public List<? extends Character> generateRandomCharacters(int numberToGenerate, Rank rank) {
        // Implementation for generating random characters of same rank
        List<Character> characters = new ArrayList<>();


        // Generate random characters
        for (int i = 0; i < numberToGenerate; i++) {
            Archetype randomArchetype = Archetype.getRandomArchetype();
            Character newCharacter = CharacterFactory.createCharacter(rank, randomArchetype);
            characters.add(newCharacter);
        }

        return characters;
    }

    public Character generateArchetype(Archetype archetype, Rank rank) {
        return CharacterFactory.createCharacter(rank, archetype);
    }


}