package org.example;

import org.example.archetypes.Warrior;
import org.example.enums.Archetype;
import org.example.enums.Rank;

import java.util.List;

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

//        // Display character information
//        System.out.println("Novice Warrior:");
//        System.out.println(noviceWarrior);
//
//        System.out.println("\nExpert Warrior:");
//        System.out.println(expertWarrior);


        CharacterGenerator characterGenerator = new CharacterGenerator();

        List<? extends Character> randomCharacters = characterGenerator.generateRandomCharacters(4, Rank.NOVICE);

        for (Character character : randomCharacters) {
            System.out.println("******************************");
            System.out.println(character.toString());
            System.out.println("******************************");
        }

//        Character specificChar = characterGenerator.generateArchetype(Archetype.MAGE,Rank.EXPERT);
//        System.out.println("\nExpert Mage:");
//        System.out.println(specificChar);


    }


}
