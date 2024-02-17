package org.example.listeners;

import org.example.CombatMove;
import org.example.GameEventListener;
import org.example.UI.UIOutputPlaceholder;
import org.example.archetypes.GameCharacter;
import org.example.enums.GameEvents;
import org.example.enums.Magnitude;
import org.example.enums.VigorState;
import org.example.events.CharacterAttackEvent;
import org.example.events.CharacterDamagedEvent;
import org.example.events.GameEvent;


public class BattleEventListener implements GameEventListener {

    @Override
    public void handleEvent(GameEvent event) {
        GameEvents eventName = event.getEventName();
        switch (eventName){
            case NewBattleEvent:
                break;

        }


    }







    // Other combat-specific events
}
