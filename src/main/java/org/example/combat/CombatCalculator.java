package org.example.combat;

import org.example.*;
import org.example.archetypes.GameCharacter;
import org.example.enums.Magnitude;
import org.example.enums.StatName;
import org.example.enums.VigorState;
import org.example.events.CharacterAttackEvent;
import org.example.events.CharacterDamagedEvent;
import org.example.events.GameEventDispatcher;

import java.util.Random;

public class CombatCalculator {
    private static GameEventDispatcher eventDispatcher;

    public static void setEventDispatcher(GameEventDispatcher dispatcher) {
        eventDispatcher = dispatcher;
    }


    public static Magnitude calculatePotentialImpact(GameCharacter attacker, GameCharacter defender, CombatMove move) {

        switch (move.getMoveType()) {
            case OFFENSIVE:
                return calculateOffensiveMove(attacker, defender, move);


        }
            return null;
    }

    public static void applyDamage(Magnitude potentialImpact, GameCharacter defender)
    {
        Vigor currentVigor = defender.getCharVigor();
        VigorState oldVigorState = currentVigor.getCurrentVigorState();

        Vigor newVigor = currentVigor.calculateImpactToVigor(potentialImpact);

        defender.setCharVigor(newVigor);

        if (GameEventDispatcher.getInstance() != null) {
            GameEventDispatcher.getInstance().dispatchEvent(new CharacterDamagedEvent(defender, potentialImpact, oldVigorState));
        }
        else{
            UIOutputPlaceholder.printToScreen("No Dsipatcher");
        }
    }


    private static Magnitude calculateOffensiveMove(GameCharacter attacker, GameCharacter defender, CombatMove move) {
        StatName mainAttackingStatName = move.getMainStat();
        Stat mainAttackingStat = attacker.getCharStat(mainAttackingStatName);
        Stat secondaryAttackingStat = attacker.getCharStat(move.getSecondaryStat());

        double randomAttackModifier = Constants.getcombatRandomMinRange() +
                (Constants.getcombatRandomMaxRange() - Constants.getcombatRandomMinRange()) * new Random().nextDouble();

        Stats attackerStats = attacker.getCharStats();
        double attackDamage = mainAttackingStat.getBaseValue() * Constants.getmainStatModifierAttack()
                + secondaryAttackingStat.getBaseValue() * Constants.getsecondaryStatModifierAttack()
                * randomAttackModifier;

        StatName oppositeDefensiveStatName = StatName.getOpposite(mainAttackingStatName);
        Stat oppositeDefensiveStat = defender.getCharStat(oppositeDefensiveStatName);
        Stat secondaryDefensiveStat = defender.getCharStat(defender.getMainDefensiveStat());

        double randomDefenseModifier = Constants.getcombatRandomMinRange() +
                (Constants.getcombatRandomMaxRange() - Constants.getcombatRandomMinRange()) * new Random().nextDouble();

        double defenseAbility = oppositeDefensiveStat.getBaseValue() * Constants.getmainStatModifierAttack()
                + secondaryDefensiveStat.getBaseValue() * Constants.getsecondaryStatModifierAttack()
                * randomDefenseModifier;

        double damageDifference = attackDamage - defenseAbility;

        double damageDifferencePercentage = damageDifference/defenseAbility;

        Magnitude potentialImpact = Magnitude.getMagnitudeFromPercentage(damageDifferencePercentage);

//        System.out.println("Combat Move Details:");
//        System.out.println("Move Name: "+move.getMoveName());
//        System.out.println("Main Attacking Stat: " + mainAttackingStatName);
//        System.out.println("Main Attacking Stat Value: " + mainAttackingStat.getBaseValue());
//        System.out.println("Secondary Attacking Stat Value: " + secondaryAttackingStat.getBaseValue());
//        System.out.println("Random Modifier for Attack Damage: " + randomAttackModifier);
//        System.out.println("Attack Damage: " + attackDamage);
//        System.out.println("Opposite Defensive Stat: " + oppositeDefensiveStatName);
//        System.out.println("Opposite Defensive Stat Value: " + oppositeDefensiveStat.getBaseValue());
//        System.out.println("Secondary Defensive Stat Value: " + secondaryDefensiveStat.getBaseValue());
//        System.out.println("Random Modifier for Defense Ability: " + randomDefenseModifier);
//        System.out.println("Defense Ability: " + defenseAbility);
//        System.out.println("Damage Difference: " + damageDifference);
//        System.out.println("Damage Difference Percentage: " + damageDifferencePercentage);
//        System.out.println("Potential Impact: " + potentialImpact);

        if (eventDispatcher != null) {
            eventDispatcher.dispatchEvent(new CharacterAttackEvent(attacker, defender, move));
        }else{
            UIOutputPlaceholder.printToScreen("No Dsipatcher");
        }




        return potentialImpact;
    }




}
