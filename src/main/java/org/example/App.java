package org.example;

import org.example.archetypes.GameCharacter;
import org.example.archetypes.Thief;
import org.example.archetypes.Warrior;
import org.example.combat.BattleManager;
import org.example.combat.CombatCalculator;
import org.example.enums.Magnitude;
import org.example.enums.Rank;
import org.example.events.CharacterAttackEvent;
import org.example.events.CharacterDamagedEvent;
import org.example.events.CombatEventListener;
import org.example.events.GameEventDispatcher;
import org.example.statemachines.GameStateMachine;

/**
 * Hello world!
 *
 */
public class App 
{

    private static GameEventDispatcher dispatcher;

    public static void main(String[] args )
    {
        System.out.println( "Hello World!" );

        // Test creating characters with different ranks
//        GameCharacter noviceWarrior = new Warrior(Rank.NOVICE);
//        GameCharacter expertWarrior = new Warrior(Rank.EXPERT);

//        // Display character information
//        System.out.println("Novice Warrior:");
//        System.out.println(noviceWarrior);
//
//        System.out.println("\nExpert Warrior:");
//        System.out.println(expertWarrior);


//        CharacterGenerator characterGenerator = new CharacterGenerator();



//        Character specificChar = characterGenerator.generateArchetype(Archetype.MAGE,Rank.EXPERT);
//        System.out.println("\nExpert Mage:");
//        System.out.println(specificChar);

//        Gson gson = new Gson();


         // Read JSON data from a file
//         InputStream inputStream = App.class.getResourceAsStream("/JSON/WarriorCombatMoves.JSON");

         // Deserialize JSON to a list of CombatMoveData
         //List<CombatMovePOJO> moves = JsonUtility.deserialize(inputStream, new ArrayList<CombatMovePOJO>().getClass());
//         List<CombatMovePOJO> moves = gson.fromJson(new InputStreamReader(inputStream), new TypeToken<List<CombatMovePOJO>>() {}.getType());


//         // Now you have a list of moves to work with
//         for (CombatMovePOJO move : moves) {
//             System.out.println(move);
//         }

//        CharacterGenerator characterGenerator = new CharacterGenerator();
//        List<? extends Character> randomCharacters = characterGenerator.generateRandomCharacters(2, Rank.NOVICE);
//
//        for (Character character : randomCharacters) {
//            System.out.println("******************************");
//            System.out.println(character.toString());
//            System.out.println("******************************");
//        }

//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(-1));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(0.01));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(0.2));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(0.3));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(0.4));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(0.5));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(0.6));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(0.7));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(0.8));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(0.9));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(0.95));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(1));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(1.3));
//        System.out.println("Selected Magnitude: " + Magnitude.getMagnitudeFromPercentage(4));

        GameStateMachine gameStateMachine = new GameStateMachine();

        boolean gameRunning = true;

        initialise();

        while(gameRunning)
        {

            gameStateMachine.update();


            // Sleep to prevent the loop from running too fast
            try {
                Thread.sleep(16); // Roughly 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }



        GameCharacter attackingThief = new Thief(Rank.NOVICE, null);
        GameCharacter defendingWarrior = new Warrior(Rank.NOVICE, null);

        System.out.println("******************************");
            System.out.println(attackingThief.toString());
            System.out.println("******************************");
        System.out.println(defendingWarrior.toString());
        System.out.println("******************************");

        CombatCalculator calc = new CombatCalculator();
        Magnitude impact =  calc.calculatePotentialImpact(attackingThief, defendingWarrior, attackingThief.getCombatMoves().getMoves().get(0));
  //      System.out.println("Final Mag: "+impact);
        calc.applyDamage(impact,defendingWarrior);

//        System.out.println("******************************");
//        System.out.println(defendingWarrior.toString());
//        System.out.println("******************************");

        impact =  calc.calculatePotentialImpact(attackingThief, defendingWarrior, attackingThief.getCombatMoves().getMoves().get(0));
  //      System.out.println("Final Mag: "+impact);
        calc.applyDamage(impact,defendingWarrior);

//        System.out.println("******************************");
//        System.out.println(defendingWarrior.toString());
//        System.out.println("******************************");

        impact =  calc.calculatePotentialImpact(attackingThief, defendingWarrior, attackingThief.getCombatMoves().getMoves().get(0));
//        System.out.println("Final Mag: "+impact);
        calc.applyDamage(impact,defendingWarrior);

//        System.out.println("******************************");
//        System.out.println(defendingWarrior.toString());
//        System.out.println("******************************");

        impact =  calc.calculatePotentialImpact(attackingThief, defendingWarrior, attackingThief.getCombatMoves().getMoves().get(0));
  //      System.out.println("Final Mag: "+impact);
        calc.applyDamage(impact,defendingWarrior);

//        System.out.println("******************************");
//        System.out.println(defendingWarrior.toString());
//        System.out.println("******************************");






    }

    private static void initialise(){
        GameEventDispatcher dispatcher = GameEventDispatcher.getInstance();

        CombatEventListener combatListener = new CombatEventListener();
        dispatcher.addListener(CharacterDamagedEvent.class, combatListener);
        dispatcher.addListener(CharacterAttackEvent.class, combatListener);

        CharacterManager.setEventDispatcher(dispatcher);
        BattleManager.setEventDispatcher(dispatcher);

        CombatCalculator.setEventDispatcher(dispatcher);


    }



    }

