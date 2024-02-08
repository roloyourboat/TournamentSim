package org.example.events;

public abstract class GameEvent {
    private final long timestamp;
    private final String name;

    public GameEvent(String name) {
        this.timestamp = System.currentTimeMillis();
        this.name = name;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getName() {
        return name;
    }
}
