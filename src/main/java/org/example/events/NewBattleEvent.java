package org.example.events;

import org.example.enums.GameEvents;

public class NewBattleEvent extends GameEvent{

    public NewBattleEvent() {
        super(GameEvents.NewBattleEvent);
    }
}