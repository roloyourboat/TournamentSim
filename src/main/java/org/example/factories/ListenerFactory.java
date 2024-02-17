package org.example.factories;

import org.example.GameEventListener;
import org.example.enums.GameEventListeners;


import java.lang.reflect.InvocationTargetException;
import java.util.EnumMap;
import java.util.Map;

public class ListenerFactory {
    private static final String BASE_PACKAGE = "org.example.listeners."; // Adjust based on your package structure
    private static final Map<GameEventListeners, GameEventListener> cache = new EnumMap<>(GameEventListeners.class);

    public static GameEventListener createListener(GameEventListeners listenerType) {
        // Return cached instance if available
        if (cache.containsKey(listenerType)) {
            return cache.get(listenerType);
        }

        String classPath = BASE_PACKAGE + listenerType.name();
        System.out.println("Class name: "+classPath);
        try {
            Class<?> listenerClass = Class.forName(classPath);
            GameEventListener listener = (GameEventListener) listenerClass.getDeclaredConstructor().newInstance();
            cache.put(listenerType, listener); // Cache the instance for future use
            return listener;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException("Could not instantiate listener for type: " + listenerType, e);
        }
    }
}