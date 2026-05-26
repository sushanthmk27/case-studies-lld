package com.scaler.game;

import com.scaler.model.Board;
import com.scaler.model.Cell;
import com.scaler.model.Constants;
import com.scaler.model.Player;

public class Game {
    private final Board board;

    private final Player player;

    private final Cell cellSymbol;

    private final Constants constants;

    public Game(Board board, Player player, Cell cellSymbol, Constants constants) {
        this.board = board;
        this.player = player;
        this.cellSymbol = cellSymbol;
        this.constants = constants;
    }

    //Check the players turn and return the symbol accordingly
    public Cell getNextMoveSymbol(Cell currentMoveSymbol){
        if(currentMoveSymbol == Cell.O){
            return Cell.X;
        }
        else{
            return Cell.O;
        }
    }

    //Check if GameOver-Game completed
    public boolean checkIfGameOver(){
        if(board.checkWinCondition(cellSymbol)){
            System.out.println("Congratulations " + player.getName() + ", you win! and game completed");
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
        if(board.checkWinCondition(currentMoveSymbol)){
            System.out.println("Congratulations " + player.getName() + ", wins the game!");
            return player.getName();
        }
        else if(board.checkIfDraw()){
            System.out.println("It's a draw!");
            return null;
        }
        else{
            return "Game continues";
        }
    }

    //Get the current board state to display to the user
    public Cell[][] getCurrentBoardStateOnGame(){
        return board.getCurrentBoardState();
    }

    public boolean setSetNameAndSymbol(String name, Cell cellSymbol){
        // add validations here
        player.setName(name);
        player.setSymbol(cellSymbol);
        return false;
    }

}
