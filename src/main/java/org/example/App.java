package org.example;

import org.example.archetypes.Warrior;
import org.example.enums.Rank;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        // Test creating characters with different ranks
        Character noviceWarrior = new Warrior(Rank.NOVICE);
        Character expertWarrior = new Warrior(Rank.EXPERT);

        // Display character information
        System.out.println("Novice Warrior:");
        System.out.println(noviceWarrior);

        System.out.println("\nExpert Warrior:");
        System.out.println(expertWarrior);
    }


}
