package org.example.listeners;

import org.example.CharacterManager;
import org.example.CombatMove;
import org.example.GameEventListener;
import org.example.UI.UIOutputPlaceholder;
import org.example.archetypes.GameCharacter;
import org.example.enums.*;
import org.example.events.CharacterCreatedEvent;
import org.example.events.CharacterCreationEvent;
import org.example.events.GameEvent;

import java.util.UUID;


public class CharacterEventListener implements GameEventListener {

    @Override
    public void handleEvent(GameEvent event) {
        GameEvents eventName = event.getEventName();
        switch (eventName){
            case CharacterCreationEvent:
                characterCreationEvent(event);
                break;
            case CharacterCreatedEvent:
                characterCreatedEvent(event);
                break;
            case CharacterUpdatedEvent:
                characterUpdatedEvent(event);
                break;

        }


    }

    private void characterCreationEvent(GameEvent event) {
        System.out.println("Creating Character...");
        CharacterCreationEvent characterCreationEvent = (CharacterCreationEvent) event;
        CharacterManager charManager = characterCreationEvent.getCharacterManager();
        Rank rank = characterCreationEvent.getRank();
        Archetype archetype = characterCreationEvent.getArchetype();
        int numberToCreate = characterCreationEvent.getNumberToCreate();
        System.out.println("Archetype: "+archetype+" Rank: "+rank+" Number To Create: "+numberToCreate);

        charManager.generateRandomCharacters(numberToCreate, rank);



    }

    private void characterUpdatedEvent(GameEvent event) {

    }

    private void characterCreatedEvent(GameEvent event) {
        CharacterCreatedEvent characterCreatedEvent = (CharacterCreatedEvent) event;
        GameCharacter newChar = characterCreatedEvent.getNewCharacter();
        UUID newCharID = characterCreatedEvent.getNewCharID();
        System.out.println("Character created -> "+newChar.getCharNameWithClass());
    }


}

