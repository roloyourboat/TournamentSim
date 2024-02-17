package org.example;

 import org.example.archetypes.GameCharacter;
 import org.example.enums.Archetype;
 import org.example.enums.Rank;
 import org.example.events.CharacterCreatedEvent;
 import org.example.events.GameEvent;
 import org.example.events.GameEventDispatcher;
 import org.example.factories.CharacterFactory;  // Import your CharacterFactory interface

 import java.util.ArrayList;
 import java.util.List;
 import java.util.UUID;

public class CharacterManager {
    //TODO Give chars a unique ID of thier own

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

    public List<GameCharacter> getUnassignedChars(int numberOfChars){
        List<GameCharacter> unassignedChars = new ArrayList<>();
        for (GameCharacter character : generatedCharacters){
            if(character.getBattleID() == null)
                unassignedChars.add(character);
        }
        System.out.println("Unassigned Size: "+unassignedChars.size());

    return  unassignedChars;
    }

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

    public List<GameCharacter> generateRandomCharacters(int numberToGenerate, Rank rank) {
        // Implementation for generating random characters of same rank
        List<GameCharacter> gameCharacters = new ArrayList<>();


        // Generate random characters
        for (int i = 0; i < numberToGenerate; i++) {
            Archetype randomArchetype = Archetype.getRandomArchetype();
            GameCharacter newGameCharacter = CharacterFactory.createCharacter(rank, randomArchetype);
            gameCharacters.add(newGameCharacter);
            generatedCharacters.add(newGameCharacter);

            GameEvent.dispatchEvent(new CharacterCreatedEvent(newGameCharacter.getCharID(),newGameCharacter));
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