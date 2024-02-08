package org.example.events;

import org.example.archetypes.GameCharacter;
import org.example.enums.Magnitude;
import org.example.enums.VigorState;

public class CharacterDamagedEvent extends GameEvent {



    private final GameCharacter defender;
    private final Magnitude potentialImpact;


    private final VigorState vigorStateBeforeDamage;

    public CharacterDamagedEvent(GameCharacter defender, Magnitude potentialImpact, VigorState vigorStateBeforeDamage) {
        super("DamageEvent");
        this.defender = defender;
        this.potentialImpact = potentialImpact;
        this.vigorStateBeforeDamage = vigorStateBeforeDamage;
    }


    public GameCharacter getDefender() {
        return defender;
    }

    public Magnitude getPotentialImpact() {
        return potentialImpact;
    }
    public VigorState getVigorStateBeforeDamage() {
        return vigorStateBeforeDamage;
    }

}