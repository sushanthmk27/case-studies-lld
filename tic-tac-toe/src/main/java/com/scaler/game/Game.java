package com.scaler.game;

import com.scaler.model.Board;
import com.scaler.model.Cell;
import com.scaler.model.Constants;
import com.scaler.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Board board;

    private final Player player;

    //private final Cell cellSymbol;

    private final Constants constants;

    private List<Player> playerDetailList;

    private int currentPlayerIndex = 0;

    public Game(Board board, Player player, Constants constants) {
        this.board = board;
        this.player = player;
        //this.cellSymbol = cellSymbol;
        this.constants = constants;
        playerDetailList = new ArrayList<>();
    }

    //Check the players turn and return the symbol accordingly
    public Cell getNextMoveSymbol(Cell currentMoveSymbol){
        if(currentMoveSymbol == Cell.O || currentMoveSymbol == Cell.EMPTY){
            return Cell.X;
        }
        else{
            return Cell.O;
        }
    }

    //Check if GameOver-Game completed
    public boolean checkIfGameOver(Cell currentMoveSymbol){
        if(board.checkWinCondition(currentMoveSymbol)){
            System.out.println("Congratulations " + player.getName() + ", you win! and game is completed");
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

    public String checkGameWinner(Cell currentMoveSymbol){
        //Here we need to fetch the last person who played the game and check if he/she is the winner or not based on the state of the board
        if(board.checkWinCondition(currentMoveSymbol)){
            System.out.println("Congratulations " + player.getName() + ", wins the game!");
            return player.getName();
      //the below logic is not required
        }
       /* else if(board.checkIfDraw()){
            System.out.println("It's a draw!");
            return null;
        }*/
        else{
            return constants.GAME_CONTINUES;
        }

    }

    //Get the current board state to display to the user
    public Cell[][] getCurrentBoardStateOnGame(){
        return board.getCurrentBoardState();
    }
    /// ////////////////////////////////////////////////////Check this method again
    public void setNameAndSymbol(String playerName, Cell cellSymbol){
        // validation will be added while getting the input from the user
        //Player player = new Player();
        //For now we can hardcode the value for testing purpose
        //playerDetailList = new ArrayList<>();
        playerDetailList.add(new Player("Alice", 'X'));
        playerDetailList.add(new Player("Bob", 'O'));

        //playerDetailList.add(new Player(playerName, cellSymbol));

    }

    //Switch turns for players
    public Cell switchTurn(Cell currentMoveSymbol){
        //Logic need to be updated here
        if(currentMoveSymbol ==  Cell.O){
            System.out.println("Its your turn to play - X ");
            return Cell.X;
        }
        else{
            System.out.println("Its your turn to play - O ");
            return Cell.O;
        }
    }

    /*Work on the game flow logic*/
    public void runGame(){
        //need to be updated to take the value in a dynamic way from the user input
        Cell currentMoveSymbol = Cell.O;
        board.createAndResetToNewBoard();
        while(!checkIfGameOver(currentMoveSymbol)){
            board.getCurrentBoardState();

            //For position value we need to get it from the user input
            board.placeTheCurrentMoveOnBoard(0,0,currentMoveSymbol);

            Cell nextMoveSymbol = switchTurn(currentMoveSymbol);
            currentMoveSymbol = nextMoveSymbol;
        }
    }


}
