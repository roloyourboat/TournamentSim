package org.example;

public class Constants {

    /*
    Combat Constants
     */
    private static double MAIN_STAT_MODIFIER_ATTACK = 2.0;
    private static double SECONDARY_STAT_MODIFIER_ATTACK = 0.5;
    private static double MAIN_STAT_MODIFIER_DEFENSE = 2.0;
    private static double SECONDARY_STAT_MODIFIER_DEFENSE = 0.5;

    private static double COMBAT_RANDOM_MIN_RANGE = 0.7;
    private static double COMBAT_RANDOM_MAX_RANGE = 1.2;

    public static final String ACTIVE_BATTLE_STATUS = "ACTIVE";
    public static final String COMPLETED_BATTLE_STATUS = "COMPLETED";
    public static double getmainStatModifierAttack() {
        return MAIN_STAT_MODIFIER_ATTACK;
    }

    public static double getsecondaryStatModifierAttack() {
        return SECONDARY_STAT_MODIFIER_ATTACK;
    }


    public static double getmainStatModifierDefense() {
        return MAIN_STAT_MODIFIER_DEFENSE;
    }

    public static double getsecondaryStatModifierDefense() {
        return SECONDARY_STAT_MODIFIER_DEFENSE;
    }

    public static double getcombatRandomMinRange() {
        return COMBAT_RANDOM_MIN_RANGE;
    }

    public static double getcombatRandomMaxRange() {
        return COMBAT_RANDOM_MAX_RANGE;
    }



}
