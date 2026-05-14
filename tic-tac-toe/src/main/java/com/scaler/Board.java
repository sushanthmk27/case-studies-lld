package com.scaler;

/*
Manages game board state and rules
 */
public class Board {
    Cell[][] boardMatrix;

    public Board(Cell[][] boardMatrix){
        this.boardMatrix = boardMatrix;
    }

    /*
        State Management Operations
    */
    //Reset board for new game
    public void createAndResetToNewBoard(){
        boardMatrix = new Cell[3][3];
    }

    // track which cells are occupied
    public boolean checkIfOccupied(int x, int y){
        return  boardMatrix[x][y] != Cell.EMPTY;
    }

    /*
        Move Operations
    */
    //Place the move on the board and check if success or failure
    //public void placeTheCurrentMoveOnBoard(int x, int y, Cell currentMove) throws CellManagementException{
    public boolean placeTheCurrentMoveOnBoard(int x, int y, Cell currentMove){
        if(checkIfOccupied(x,y)){
            //throw new CellManagementException("Cell is already occupied, try a different cell");
            System.out.println("Cell is already occupied, try a different cell");
            return false;
        }
        boardMatrix[x][y] = currentMove;
        return true;
    }

    /*
    Check for win conditions
     */
    //We check for all 3 rows, 3 columns and 2 diagonals for a win condition
    // For future scope, update the code to take dynamic values so that the board size can be increased
    public boolean checkWinCondition(Cell currentMove){
            for(int i=0; i<3; i++){
                if(boardMatrix[i][0] == currentMove && boardMatrix[i][1] == currentMove && boardMatrix[i][2] == currentMove){
                    return true;
                }

                if(boardMatrix[0][i] == currentMove && boardMatrix[1][i] == currentMove && boardMatrix[2][i] == currentMove){
                    return true;
                }
            }
            if(boardMatrix[0][0] == currentMove && boardMatrix[1][1] == currentMove && boardMatrix[2][2] == currentMove){
                return true;
            }
            if(boardMatrix[0][3] == currentMove && boardMatrix[1][1] == currentMove && boardMatrix[2][0] == currentMove){
                return true;
            }
            return false;
    }



}
