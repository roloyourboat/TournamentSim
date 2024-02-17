package org.example.events;

import org.example.enums.GameEvents;

public class CharacterUpdatedEvent extends GameEvent {
    public CharacterUpdatedEvent() {
        super(GameEvents.CharacterUpdatedEvent);
    }
}