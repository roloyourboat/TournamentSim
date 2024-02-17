package org.example.statemachines;

import org.example.CharacterManager;
import org.example.Tournament;
import org.example.UI.MainMenuPlaceholder;
import org.example.UI.UIInputPlaceholder;
import org.example.combat.BattleManager;
import org.example.enums.GameState;
import org.example.enums.Rank;
import org.example.enums.TournamentLevel;
import org.example.events.CharacterCreationEvent;
import org.example.events.GameEvent;
import org.example.events.GameEventDispatcher;

import java.util.UUID;

public class GameStateMachine {
    private GameState currentState;
    private BattleManager battleManager;
    private CharacterManager charManager;
    private GameEventDispatcher dispatcher;
    private Tournament tournament;

    public GameStateMachine() {

    }


    public GameStateMachine(GameEventDispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.charManager = new CharacterManager();
        this.battleManager = new BattleManager(charManager);
        this.currentState = GameState.MAIN_MENU;

        transitionTo(GameState.MAIN_MENU);
    }

    public void transitionTo(GameState nextState) {
        currentState = nextState;
        switch (nextState) {
            case MAIN_MENU:
                transitionToMainMenu();
                break;
            case IN_GAME:
                // Handle transition to in-game state
                break;
            case IN_BATTLE:
                transitionToBattle();
                break;
            case RESULTS:
                transitionToResults();
                break;
            case PAUSED:
                // Handle game pausing
                break;
            case GAME_OVER:
                transitionToGameOver();
                break;
            case IN_TOURNAMENT:
                transitionInTournament();
                break;
        }
    }

    private void transitionInTournament() {
        tournament = new Tournament(charManager,battleManager,8, Rank.NOVICE);
        tournament.display();
        currentState = GameState.IN_TOURNAMENT;
    }

    private void transitionToResults() {
       battleManager.displayPreviousResults();
    }

    private void transitionToGameOver() {
        System.exit(0);
    }

    public void transitionToMainMenu(){
        MainMenuPlaceholder menu = new MainMenuPlaceholder();
        menu.displayMenu();
        int playerChoice = UIInputPlaceholder.getIntFromInput("Please select from the above menu: ", new int[]{1,2,3,4});

        switch (playerChoice){
            case 1:
                transitionTo(GameState.IN_BATTLE);
                break;
            case 2:
                transitionTo(GameState.RESULTS);
                break;
            case 3:
                transitionTo(GameState.GAME_OVER);
                break;
            case 4:
                transitionTo(GameState.IN_TOURNAMENT);
                break;

        }

    }

    public void transitionToBattle(){
//        List<GameCharacter> combatants = new CharacterGenerator().generateRandomCharacters(2, Rank.NOVICE);
//        battleManager.createNewBattle(combatants);
//        currentState = GameState.IN_BATTLE; // Assume you have an IN_BATTLE state
//        // Optionally, store battleId for reference
        //dispatcher.dispatchEvent(new NewBattleEvent());

        generateRandomBattles(2);
    }
//TODO use Manger as a factory properly
    //TODO seperate char createion so its only managed by CharGen/factory
    private void generateRandomBattles(int numberOfBattlesToGenerate){
        for(int battleNumber =0; battleNumber < numberOfBattlesToGenerate;battleNumber++ ){
            //List<GameCharacter> combatants = new CharacterManager().generateRandomCharacters(2, Rank.NOVICE);
            UUID newBattleID = battleManager.generateNewBattleID();

            GameEvent.dispatchEvent(new CharacterCreationEvent(charManager, Rank.NOVICE,2));
            //charManager.generateRandomCharacters(2,Rank.NOVICE);
            //List<GameCharacter> combatants = new CharacterManager().generateArchetype(2,Archetype.WARRIOR, Rank.NOVICE);
            battleManager.createNewBattle(newBattleID);
        }
        currentState = GameState.IN_BATTLE;
    }

    public void update() {
        switch (currentState) {
            case MAIN_MENU:
                updateMainMenu();
                break;
            case IN_GAME:
                updateInGame();
                break;
            case IN_BATTLE:
                updateInBattle();
                break;
            case RESULTS:
                updateResults();
                break;
            case PAUSED:
                updatePaused();
                break;
            case GAME_OVER:
                updateGameOver();
                break;
            case IN_TOURNAMENT:
                updateInTournament();
                break;

        }
    }

    private void updateInTournament() {
        battleManager.updateAllBattles();

        if(battleManager.areBattlesFinished()){
            tournament.display();
            tournament.advanceRound();
            if(tournament.isTournamentFinished()){
                transitionTo(GameState.MAIN_MENU);
            }
        }
    }

    private void updateResults() {
        transitionTo(GameState.MAIN_MENU);
    }

    private void updateMainMenu() {
        // Display main menu and handle menu input
        // Transition to IN_GAME based on input
//        System.out.println("Updating Main Menu");
//        this.transitionTo(GameState.IN_BATTLE);
    }

    private void updateInGame() {
        // Update game logic, process input, and render the game
        // Transition to PAUSED or GAME_OVER based on game events
    }

    private void updateInBattle() {
        // Update game logic, process input, and render the game
        // Transition to PAUSED or GAME_OVER based on game events
        //System.out.println("Updating Battle");
        battleManager.updateAllBattles();

        if(battleManager.areBattlesFinished()){
            transitionTo(GameState.MAIN_MENU);
        }

    }

    private void updatePaused() {
        // Display pause menu and handle pause menu input
        // Transition back to IN_GAME or to MAIN_MENU based on input
    }

    private void updateGameOver() {
        // Display game over screen and handle input
        // Transition to IN_GAME or quit based on input
    }

    public GameState getCurrentState() {
        return currentState;
    }
    // Additional methods to handle state-specific logic
}