package org.example.events;

import org.example.archetypes.GameCharacter;
import org.example.enums.GameEvents;

import java.util.UUID;

public class CharacterCreatedEvent extends GameEvent {
    private final GameCharacter newCharacter;

    public GameCharacter getNewCharacter() {
        return newCharacter;
    }

    public UUID getNewCharID() {
        return newCharID;
    }

    private final UUID newCharID;
    public CharacterCreatedEvent(UUID newCharID, GameCharacter newCharacter) {
        super(GameEvents.CharacterCreatedEvent);
        this.newCharacter = newCharacter;
        this.newCharID = newCharID;
    }
}
