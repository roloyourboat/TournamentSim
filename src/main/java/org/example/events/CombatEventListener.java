package org.example.events;

import org.example.archetypes.GameCharacter;
import org.example.CombatMove;
import org.example.UIOutputPlaceholder;
import org.example.enums.Magnitude;
import org.example.enums.VigorState;

public class CombatEventListener implements GameEventListener  {

    @Override
    public void handleEvent(GameEvent event) {
        String eventClassName = event.getClass().getSimpleName();
        switch (eventClassName){
            case "CharacterDamagedEvent":
                characterDamagedEvent(event);
                break;
            case "CharacterAttackEvent":
                characterAttackEvent(event);
                break;

        }


    }

    private void characterAttackEvent(GameEvent event) {
        CharacterAttackEvent charAttackEvent = (CharacterAttackEvent) event;

        GameCharacter attacker = charAttackEvent.getAttacker();
        GameCharacter defender = charAttackEvent.getDefender();
        CombatMove moveUsed = charAttackEvent.getMove();

        String attackerName = attacker.getCharName();
        String attackerClass = attacker.getCharClass().enumToClassName();

        String defenderName = defender.getCharName();
        String defenderClass = defender.getCharClass().enumToClassName();

        String moveName = moveUsed.getMoveName();

        UIOutputPlaceholder.printToScreen(attackerName + " the " + attackerClass + " is attacking "
            + defenderName + " the "+defenderClass+ " with "+ moveName);

    }


    private void characterDamagedEvent(GameEvent event)
    {
        CharacterDamagedEvent charDamagedEvent = (CharacterDamagedEvent) event;
        GameCharacter defender = charDamagedEvent.getDefender();

        String defenderName = defender.getCharName();
        String defenderClass = defender.getCharClass().enumToClassName();

        Magnitude potentialDamage = charDamagedEvent.getPotentialImpact();

        VigorState previousVigorState = charDamagedEvent.getVigorStateBeforeDamage();
        VigorState currentVigorState = defender.getCharVigor().getCurrentVigorState();

        UIOutputPlaceholder.printToScreen(defenderName + " the " + defenderClass + " was hit by an attack with "+potentialDamage+" potential.");


        switch (currentVigorState.compare(previousVigorState)){
            case GREATER_THAN:
                UIOutputPlaceholder.printToScreen("They are no longer "+previousVigorState+" and are now "+currentVigorState+".");
                break;
            case EQUAL:
                UIOutputPlaceholder.printToScreen("They shrug it off and remain "+currentVigorState+".");
                break;
            case LESS_THAN:
                UIOutputPlaceholder.printToScreen("Error");
                break;

        }


    }
    // Other combat-specific events
}
