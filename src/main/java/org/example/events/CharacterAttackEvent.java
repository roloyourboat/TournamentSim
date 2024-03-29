package org.example.events;

import org.example.CombatMove;
import org.example.archetypes.GameCharacter;
import org.example.enums.GameEvents;

public class CharacterAttackEvent extends GameEvent {


    private final GameCharacter attacker;
        private final GameCharacter defender;
        private final CombatMove move;

        public CharacterAttackEvent(GameCharacter attacker, GameCharacter defender, CombatMove move) {
            super(GameEvents.CharacterAttackEvent);
            this.attacker = attacker;
            this.defender = defender;
            this.move = move;
        }

    public GameCharacter getAttacker() {
        return attacker;
    }

    public GameCharacter getDefender() {
        return defender;
    }

    public CombatMove getMove() {
        return move;
    }
    }

