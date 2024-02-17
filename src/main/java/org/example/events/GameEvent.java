package org.example.events;

import org.example.UI.UIOutputPlaceholder;
import org.example.enums.GameEvents;

public abstract class GameEvent {
    private final long timestamp;

    public GameEvents getEventName() {
        return eventName;
    }

    // private final String name;
    private final GameEvents eventName;

    public GameEvent(GameEvents eventName) {
        this.eventName = eventName;
        this.timestamp = System.currentTimeMillis();
    }

    public long getTimestamp() {
        return timestamp;
    }

    public static void dispatchEvent(GameEvent gameEvent){
        if (GameEventDispatcher.getInstance() != null) {
            GameEventDispatcher.getInstance().dispatchEvent(gameEvent);
        }
        else{
            UIOutputPlaceholder.printToScreen("No Dispatcher");
        }
    }

}


