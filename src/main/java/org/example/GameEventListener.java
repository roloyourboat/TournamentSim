package org.example;

import org.example.events.GameEvent;

public interface GameEventListener {
        void handleEvent(GameEvent event);

}
