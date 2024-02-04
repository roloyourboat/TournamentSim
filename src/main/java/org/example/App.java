package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.archetypes.Character;
import org.example.archetypes.Warrior;
import org.example.enums.Rank;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static <CombatMoveData> void main(String[] args )
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



//        Character specificChar = characterGenerator.generateArchetype(Archetype.MAGE,Rank.EXPERT);
//        System.out.println("\nExpert Mage:");
//        System.out.println(specificChar);

        Gson gson = new Gson();


         // Read JSON data from a file
         InputStream inputStream = App.class.getResourceAsStream("/JSON/WarriorCombatMoves.JSON");

         // Deserialize JSON to a list of CombatMoveData
         //List<CombatMovePOJO> moves = JsonUtility.deserialize(inputStream, new ArrayList<CombatMovePOJO>().getClass());
         List<CombatMovePOJO> moves = gson.fromJson(new InputStreamReader(inputStream), new TypeToken<List<CombatMovePOJO>>() {}.getType());


//         // Now you have a list of moves to work with
//         for (CombatMovePOJO move : moves) {
//             System.out.println(move);
//         }


        List<? extends Character> randomCharacters = characterGenerator.generateRandomCharacters(4, Rank.NOVICE);

        for (Character character : randomCharacters) {
            System.out.println("******************************");
            System.out.println(character.toString());
            System.out.println("******************************");
        }


    }


}
