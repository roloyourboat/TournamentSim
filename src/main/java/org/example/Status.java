package org.example;

import org.example.enums.StatusEffect;

import java.util.HashMap;
import java.util.Map;

public class Status {
    private Map<StatusEffect, Integer> statusEffects;

    public Status() {
        statusEffects = new HashMap<>();
    }

    /**
     * Apply a status effect with a duration.
     *
     * @param effect   The status effect to apply.
     * @param duration The duration of the status effect in turns.
     */
    public void applyStatus(StatusEffect effect, int duration) {
        statusEffects.put(effect, duration);
    }

    /**
     * Remove a specific status effect.
     *
     * @param effect The status effect to remove.
     */
    public void removeStatus(StatusEffect effect) {
        statusEffects.remove(effect);
    }

    /**
     * Check if a character is affected by a specific status effect.
     *
     * @param effect The status effect to check.
     * @return True if the character has the status effect, false otherwise.
     */
    public boolean hasStatus(StatusEffect effect) {
        return statusEffects.containsKey(effect);
    }

    /**
     * Update the duration of status effects.
     * Call this method at the beginning of each turn to decrease the duration of active status effects.
     */
    public void updateStatusDuration() {
        Map<StatusEffect, Integer> updatedEffects = new HashMap<>();
        for (Map.Entry<StatusEffect, Integer> entry : statusEffects.entrySet()) {
            StatusEffect effect = entry.getKey();
            int duration = entry.getValue() - 1;
            if (duration > 0) {
                updatedEffects.put(effect, duration);
            }
        }
        statusEffects = updatedEffects;
    }
}
