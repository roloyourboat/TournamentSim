package org.example.events;

import org.example.archetypes.GameCharacter;
import org.example.enums.Magnitude;

public class DamageEvent extends GameEvent {
    private final GameCharacter defender;
    private final Magnitude potentialImpact;

    public DamageEvent(GameCharacter defender, Magnitude potentialImpact) {
        super("DamageEvent");
        this.defender = defender;
        this.potentialImpact = potentialImpact;
    }

    // Getters
}