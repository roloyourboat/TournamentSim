package org.example;

 import org.example.archetypes.GameCharacter;
 import org.example.enums.Archetype;
 import org.example.enums.Rank;
 import org.example.factories.CharacterFactory;  // Import your CharacterFactory interface

 import java.util.ArrayList;
 import java.util.List;

public class CharacterGenerator {
        public CharacterGenerator() {
        }

    public List<GameCharacter> generateRandomCharacters(int numberToGenerate, Rank rank) {
        // Implementation for generating random characters of same rank
        List<GameCharacter> gameCharacters = new ArrayList<>();


        // Generate random characters
        for (int i = 0; i < numberToGenerate; i++) {
            Archetype randomArchetype = Archetype.getRandomArchetype();
            GameCharacter newGameCharacter = CharacterFactory.createCharacter(rank, randomArchetype);
            gameCharacters.add(newGameCharacter);
        }

        return gameCharacters;
    }

    public List<GameCharacter> generateArchetype(int numberToGenerate,Archetype archetype, Rank rank) {


        List<GameCharacter> gameCharacters = new ArrayList<>();


        // Generate random characters
        for (int i = 0; i < numberToGenerate; i++) {
            GameCharacter newGameCharacter = CharacterFactory.createCharacter(rank, archetype);
            gameCharacters.add(newGameCharacter);
        }

        return gameCharacters;
    }


}