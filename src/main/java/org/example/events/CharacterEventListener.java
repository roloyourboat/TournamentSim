package org.example.events;

import org.example.CombatMove;
import org.example.UI.UIOutputPlaceholder;
import org.example.archetypes.GameCharacter;
import org.example.enums.Magnitude;
import org.example.enums.VigorState;

public class CharacterEventListener implements GameEventListener  {

    @Override
    public void handleEvent(GameEvent event) {
        String eventClassName = event.getClass().getSimpleName();
        switch (eventClassName){
            case "CharacterCreatedEvent":
                characterCreatedEvent(event);
                break;
            case "CharacterUpdatedEvent":
                characterUpdatedEvent(event);
                break;

        }


    }

    private void characterUpdatedEvent(GameEvent event) {
    }

    private void characterCreatedEvent(GameEvent event) {
    }


}

