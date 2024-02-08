package org.example;

 import org.example.archetypes.GameCharacter;
 import org.example.enums.Archetype;
 import org.example.enums.Rank;
 import org.example.events.GameEventDispatcher;
 import org.example.factories.CharacterFactory;  // Import your CharacterFactory interface

 import java.util.ArrayList;
 import java.util.List;
 import java.util.UUID;

public class CharacterManager {

    private static GameEventDispatcher eventDispatcher;

    public static void setEventDispatcher(GameEventDispatcher dispatcher) {
        eventDispatcher = dispatcher;
    }
    public List<GameCharacter> getGeneratedCharacters() {
        return generatedCharacters;
    }

    public void setGeneratedCharacters(List<GameCharacter> generatedCharacters) {
        this.generatedCharacters = generatedCharacters;
    }

    private List<GameCharacter> generatedCharacters;

    public List<GameCharacter> getCharsByUUID(UUID uuid) {
        List<GameCharacter> matchingCharacters = new ArrayList<>();
        for (GameCharacter character : generatedCharacters) {
            if (character.getBattleID().equals(uuid)) {
                matchingCharacters.add(character);
            }
        }
        return matchingCharacters;
    }

        public CharacterManager() {
        this.generatedCharacters = new ArrayList<>();
        }

    public List<GameCharacter> generateRandomCharacters(int numberToGenerate, Rank rank, UUID battleID) {
        // Implementation for generating random characters of same rank
        List<GameCharacter> gameCharacters = new ArrayList<>();


        // Generate random characters
        for (int i = 0; i < numberToGenerate; i++) {
            Archetype randomArchetype = Archetype.getRandomArchetype();
            GameCharacter newGameCharacter = CharacterFactory.createCharacter(rank, randomArchetype, battleID);
            gameCharacters.add(newGameCharacter);
            generatedCharacters.add(newGameCharacter);
        }

        return gameCharacters;
    }

    public List<GameCharacter> generateArchetype(int numberToGenerate,Archetype archetype, Rank rank) {


        List<GameCharacter> gameCharacters = new ArrayList<>();


        // Generate random characters
        for (int i = 0; i < numberToGenerate; i++) {
            GameCharacter newGameCharacter = CharacterFactory.createCharacter(rank, archetype, null);
            gameCharacters.add(newGameCharacter);
        }

        return gameCharacters;
    }


}