package org.example.enums;

import org.example.events.GameEvent;

import java.util.ArrayList;
import java.util.List;

public enum GameEvents {

    CharacterAttackEvent(GameEventListeners.CombatEventListener),
    CharacterDamagedEvent(GameEventListeners.CombatEventListener),


    CharacterCreatedEvent(GameEventListeners.CharacterEventListener),
    CharacterCreationEvent(GameEventListeners.CharacterEventListener),
    CharacterUpdatedEvent(GameEventListeners.CharacterEventListener),

    NewBattleEvent(GameEventListeners.BattleEventListener);


    private final GameEventListeners listener;

    GameEvents(GameEventListeners listener) {
        this.listener = listener;
    }

    // Static method to get all events for a given listener
    public static List<GameEvents> getEventsByListener(GameEventListeners targetListener) {
        List<GameEvents> matchingEvents = new ArrayList<>();
        for (GameEvents event : GameEvents.values()) {
            if (event.getListener() == targetListener) {
                matchingEvents.add(event);
            }
        }
        return matchingEvents;
    }

    public GameEventListeners getListener() {
        return listener;
    }

    public Class<? extends GameEvent> enumToClass() {
        String basePackage = "org.example.events."; // Adjust based on your actual package structure
        String className = basePackage + this.name();
        try {
            return (Class<? extends GameEvent>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Event class not found for: " + this.name(), e);
        }
    }
}

