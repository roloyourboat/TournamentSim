package org.example;

import org.example.combat.BattleManager;
import org.example.combat.CombatCalculator;
import org.example.enums.GameEventListeners;
import org.example.enums.GameEvents;
import org.example.enums.Rank;
import org.example.events.*;
import org.example.factories.ListenerFactory;
import org.example.statemachines.GameStateMachine;

import java.util.List;

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



        boolean gameRunning = true;




        initialise();



        GameStateMachine gameStateMachine = new GameStateMachine(dispatcher);



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


    }

    private static void initialise(){
        System.out.println("Start Init");
        dispatcher = GameEventDispatcher.getInstance();


        initialiseListeners();

        CharacterManager.setEventDispatcher(dispatcher);
        BattleManager.setEventDispatcher(dispatcher);
        CombatCalculator.setEventDispatcher(dispatcher);


    }

    private static void initialiseListeners() {
        for (GameEventListeners listenerType : GameEventListeners.values()) {
            GameEventListener listener = ListenerFactory.createListener(listenerType);
            // Assuming you have a method to get the event classes associated with a listener type
            List<GameEvents> events = GameEvents.getEventsByListener(listenerType);
            for (GameEvents event : events) {

                try {
                    Class<? extends GameEvent> eventClass = event.enumToClass();
                    System.out.println("Event: "+event.enumToClass());
                    dispatcher.addListener(eventClass, listener);
                } catch (IllegalArgumentException e) {
                    // Handle the error appropriately
                    System.err.println("Error resolving event class: " + e.getMessage());
                }
            }
        }
    }



    }

