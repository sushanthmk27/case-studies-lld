package com.scaler.model;

import com.scaler.exception.OutOfRangeException;

/*
Manages game board state and rules
 */
public class Board {

    private Cell[][] boardMatrix;

    private Constants constants;

    private static final int ROW_SIZE = 3;
    private static final int COLUMN_SIZE = 3;

//    public Board(Cell[][] boardMatrix){
//        this.boardMatrix = boardMatrix;
//    }

    /*
        State Management Operations
    */
    //Reset board for new game
    public Cell[][] createAndResetToNewBoard(){
        boardMatrix = new Cell[ROW_SIZE][COLUMN_SIZE];  // default values will be 0 in each cell
        for(int i=0; i<ROW_SIZE; i++){
            for(int j=0; j<COLUMN_SIZE; j++){
                boardMatrix[i][j] = Cell.EMPTY;
            }
        }
        System.out.println("New Board Created!");
        return boardMatrix;
    }

    // track which cells are occupied
    public boolean checkIfOccupied(int x, int y) throws OutOfRangeException {
        System.out.println("Running checkIfOccupied()");
        if(x<0 || y<0 || x>=ROW_SIZE || y>=COLUMN_SIZE){
            System.out.println("Invalid cell position, try again");
            throw new OutOfRangeException("Invalid cell position, try again");
        }
        return  boardMatrix[x][y] != Cell.EMPTY;
    }

    /*
        Move Operations
    */
    //Place the move on the board and check if success or failure
    //public void placeTheCurrentMoveOnBoard(int x, int y, Cell currentMove) throws CellManagementException{
    public boolean placeTheCurrentMoveOnBoard(int x, int y, Cell currentMove) throws OutOfRangeException{
        if(x<0 || y<0 || x>=ROW_SIZE || y>=COLUMN_SIZE){
            System.out.println("Invalid cell position, try again");
            throw new OutOfRangeException("Invalid cell position, try again");
        }
        if(checkIfOccupied(x,y)){
            //throw new CellManagementException("Cell is already occupied, try a different cell");
            System.out.println("Cell is already occupied, try a different cell");
            return false;
        }
        boardMatrix[x][y] = currentMove;
        System.out.println("Cell is not occupied, successfully symbol is placed");
        return true;
    }

    /*
    Check for win conditions
     */
    //We check for all 3 rows, 3 columns and 2 diagonals for a win condition
    // For future scope, update the code to take dynamic values so that the board size can be increased
    public boolean checkWinCondition(Cell currentMove){
        System.out.println("Running checkWinCondition()");
            for(int i=0; i<3; i++){
                if(boardMatrix[i][0] == currentMove && boardMatrix[i][1] == currentMove && boardMatrix[i][2] == currentMove){
                    System.out.println("Symbols in 1 row match");
                    return true;
                }

                if(boardMatrix[0][i] == currentMove && boardMatrix[1][i] == currentMove && boardMatrix[2][i] == currentMove){
                    System.out.println("Symbols in 1 column match");
                    return true;
                }
            }

            if(boardMatrix[0][0] == currentMove && boardMatrix[1][1] == currentMove && boardMatrix[2][2] == currentMove){
                System.out.println("Symbols in diagonal match");
                return true;
            }

            if(boardMatrix[0][2] == currentMove && boardMatrix[1][1] == currentMove && boardMatrix[2][0] == currentMove){
                System.out.println("Symbols in anti-diagonal match");
                return true;
            }
            return false;
    }

    //Check for draw conditions
    public boolean checkIfDraw(){
        System.out.println("Running checkIfDraw()");
        //return checkIfBoardIsFull(boardMatrix); // this condition wont validate if someone has already won the game, so we need to check for win condition as well
        return checkIfBoardIsFull() && !checkWinCondition(Cell.X) && !checkWinCondition(Cell.O);
    }

    /*
    * Query Operations
    */
    //Check if the board is full - for now we will work for 3*3 size board - future scope is to make it dynamic
    public boolean checkIfBoardIsFull() {
        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COLUMN_SIZE; j++) {
                if (boardMatrix[i][j] == Cell.EMPTY) {
                    System.out.println("Cell is Empty!");
                    return false;
                }
            }
        }
        System.out.println("Board is full!");
        return true;
    }

    // Get value at board position - for now we will work for 3*3 size board - future scope is to make it dynamic - unused method currently
    public Cell getValAtPosition(int x, int y) throws OutOfRangeException {
        if(x<0 || y<0 || x>=ROW_SIZE || y>=COLUMN_SIZE){
            System.out.println("Invalid cell position, try again");
            throw new OutOfRangeException("Invalid cell position, try again");
        }
        System.out.println("Symbol at the give position is - " + boardMatrix[x][y]);
        return boardMatrix[x][y];
    }

    //Get current board state - check if this is required or not, as we are already maintaining the board state in the game class
    public Cell[][] getCurrentBoardState(){
        System.out.println("Running getCurrentBoardState()");
        return boardMatrix;
    }
}
