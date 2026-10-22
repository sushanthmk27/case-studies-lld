package com.scaler.game;

import com.scaler.model.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Board board;

    private final Player player;

    //private final CellState cellSymbol;

    private final Constants constants;

    private List<Player> playerDetailList;

    private int currentPlayerIndex = 0;

    CellState[][] gameBoardMatrix;

    public Game(Board board, Player player, Constants constants) {
        this.board = board;
        this.player = player;
        //this.cellSymbol = cellSymbol;
        this.constants = constants;
        playerDetailList = new ArrayList<>();
    }

    //Check the players turn and return the symbol accordingly
    public CellState getNextMoveSymbol(CellState currentMoveSymbol){
        if(currentMoveSymbol == CellState.O || currentMoveSymbol == CellState.EMPTY){
            return CellState.X;
        }
        else{
            return CellState.O;
        }
    }

    //Check if GameOver-Game completed
    public boolean checkIfGameOver(CellState currentMoveSymbol){
        if(board.checkWinCondition(currentMoveSymbol)){
            //System.out.println("Congratulations " + player.getName() + ", you win! and game is completed");
            return true;
        }
        else if(board.checkIfDraw()){
            System.out.println("It's a draw!");
            return true;
        }
        else{
            return false;
        }
    }

    //Logic change required here, as we need to check the last person who played the game and check if he/she is the winner or not based on the state of the board
    public String checkGameWinner(int playerIndex){
        CellState playerMoveSymbol = playerDetailList.get(playerIndex).getSymbol();
        //Here we need to fetch the last person who played the game and check if he/she is the winner or not based on the state of the board
        if(board.checkWinCondition(playerMoveSymbol)){
            System.out.println("Congratulations " + playerDetailList.get(playerIndex).getName() + ", wins the game!");
            return playerDetailList.get(playerIndex).getName();
      //the below logic is not required
        }
       /* else if(board.checkIfDraw()){
            System.out.println("It's a draw!");
            return null;
        }*/
        else{
            return constants.GAME_OVER;
        }

    }

    //Get the current board state to display to the user
    public CellState[][] getCurrentBoardStateOnGame(){
        return board.getCurrentBoardState();
    }
    /// ////////////////////////////////////////////////////Check this method again
    public void setNameAndSymbol(String playerName, CellState cellStateSymbol){
        // validation will be added while getting the input from the user
        //Player player = new Player();
        //For now we can hardcode the value for testing purpose
        //playerDetailList = new ArrayList<>();
        playerDetailList.add(new Player("Alice", CellState.X));
        playerDetailList.add(new Player("Bob", CellState.O));

        //playerDetailList.add(new Player(playerName, cellStateSymbol));
    }

    //Logic to switch turns for players
    public int switchTurn(CellState currentMoveSymbol){
        currentPlayerIndex = (currentPlayerIndex+1)%playerDetailList.size();
        return currentPlayerIndex;
    }
        //Logic need to be updated here
/*        if(currentMoveSymbol ==  CellState.O){
            System.out.println("Its your turn to play - X ");
            return CellState.X;
        }
        else{
            System.out.println("Its your turn to play - O ");
            return CellState.O;
        }*/


    public Player getCurrentPlayer(){
        return playerDetailList.get(currentPlayerIndex);
    }

    /*Work on the game flow logic*/
    public void runGame(){
        gameBoardMatrix = board.createAndResetToNewBoard();
        //need to be updated to take the value in a dynamic way from the user input
        boolean movePlaced = false;

        //by default the first player will be the one who is at index 0 in the playerDetailList, can be updated later to take the input from the user for who wants to play first
        if(playerDetailList.isEmpty()){ //Add custom Exception for this case, as we are not able to start the game without players
            System.out.println("No players available to start the game.");
            throw new IllegalStateException("No players available to start the game.");
            //return;
        }
        CellState currentMoveSymbol = playerDetailList.get(currentPlayerIndex).getSymbol();
        //gameBoardMatrix = board.createAndResetToNewBoard();   // check this because we dont need to createAnd Reset the board each time the game is run, we can do it once in the constructor of the Game class
        while(true){
            //check if the below call is required or not, as we are already maintaining the board state in the game class
            //board.getCurrentBoardState();

            //For position value we need to get it from the user input
            while(!movePlaced){
                // Get position input from the user
                // For now, we'll use hardcoded values for testing
                movePlaced = board.placeTheCurrentMoveOnBoard(0,0,currentMoveSymbol); // method returns BOOLEAN value, hence if the returned value is false then we need to take the input from the user again for the same player
            }
            movePlaced = false; // reset the movePlaced flag for the next player's turn
            if(checkIfGameOver(currentMoveSymbol)){
                break;
            }

            currentPlayerIndex = switchTurn(currentMoveSymbol);
            CellState nextMoveSymbol = playerDetailList.get(currentPlayerIndex).getSymbol();
            currentMoveSymbol = nextMoveSymbol;
        }
        String winnerStatus = checkGameWinner(currentPlayerIndex);
        if(winnerStatus.equals(constants.GAME_OVER)){
            System.out.println("Game Over with no winner");
        }
        else{
            System.out.println("Congratulations " + winnerStatus + ", wins the game!");
        }
    }



}
