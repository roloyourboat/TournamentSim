package org.example.events;

import org.example.CharacterManager;
import org.example.enums.Archetype;
import org.example.enums.GameEvents;
import org.example.enums.Rank;

import java.util.UUID;

public class CharacterCreationEvent extends GameEvent {




    public Rank getRank() {
        return rank;
    }

    public Archetype getArchetype() {
        return archetype;
    }

    public int getNumberToCreate() {
        return numberToCreate;
    }

    public CharacterManager getCharacterManager() {
        return charManager;
    }

    private CharacterManager charManager;
    private final Rank rank;
    private final Archetype archetype;
    private final int numberToCreate;

    public CharacterCreationEvent(CharacterManager charManager,Rank rank, Archetype archetype, int numberToCreate) {
        super(GameEvents.CharacterCreationEvent);
        this.charManager = charManager;
        this.rank = rank;
        this.archetype = archetype;
        this.numberToCreate = numberToCreate;
    }

    public CharacterCreationEvent(CharacterManager charManager, Rank rank, int numberToCreate) {
        super(GameEvents.CharacterCreationEvent);
        this.charManager = charManager;
        this.rank = rank;
        this.archetype = null;
        this.numberToCreate = numberToCreate;
    }


}
