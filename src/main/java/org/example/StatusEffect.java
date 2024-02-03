package org.example;

public enum StatusEffect {
    POISONED("Poisoned"),
    ENRAGED("Enraged"),
    REGENERATING("Regenerating"),
    // Add more status effects as needed
    ;

    private final String displayName;

    StatusEffect(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
