package org.example.events;



import org.example.GameEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameEventDispatcher {
    private static GameEventDispatcher instance;
        private GameEventDispatcher() {
            // Private constructor to prevent instantiation
        }

        public static GameEventDispatcher getInstance() {
            if (instance == null) {
                instance = new GameEventDispatcher();
            }
            return instance;
       }


    private Map<Class<? extends GameEvent>, List<GameEventListener>> listenersMap = new HashMap<>();

    // Method to add a listener for a specific event type
    public void addListener(Class<? extends GameEvent> eventType, GameEventListener listener) {
        listenersMap.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    // Method to remove a listener for a specific event type
    public void removeListener(Class<? extends GameEvent> eventType, GameEventListener listener) {
        List<GameEventListener> listeners = listenersMap.get(eventType);
        if (listeners != null) {
            listeners.remove(listener);
            if (listeners.isEmpty()) {
                listenersMap.remove(eventType);
            }
        }
    }

    // Method to dispatch an event to all registered listeners for that event type
    public void dispatchEvent(GameEvent event) {
        List<GameEventListener> listeners = listenersMap.get(event.getClass());
        if (listeners != null) {
            for (GameEventListener listener : new ArrayList<>(listeners)) {
                listener.handleEvent(event);
            }
        }
    }
}
