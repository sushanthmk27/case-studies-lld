package com.scaler.model;

import java.util.Scanner;

public class InputAndDisplay {
    private final Scanner sc;

    public InputAndDisplay(Scanner scanner) {
        this.sc = scanner;
    }

    //public void displayBoard(int[][] board) {
    public void displayBoard(CellState[][] board){
        for (int i = 0; i < Constants.ROW_SIZE; i++) {
            for (int j = 0; j < Constants.COLUMN_SIZE; j++) {
                String cellValue;
                if(board[i][j] == CellState.X){
                    //System.out.print("X  ");
                    cellValue = "X";
                } else if(board[i][j] == CellState.O){
                    //System.out.print("O  ");
                    cellValue = "O";
                } else {
                    //System.out.print(board[i][j] + "  ");
                    cellValue =  String.valueOf(i * Constants.COLUMN_SIZE * j + 1);
                }

                System.out.println(" "+cellValue+" ");

                if(j < Constants.COLUMN_SIZE-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < Constants.ROW_SIZE-1){
                System.out.println("---+---+---");
            }
        }
    }

    // Here we can update this further by taking the box number as the user input
    /* Here we only select the box where the user wants to place the symbol,
        and then we can convert that box number into row and column values  */
    public int[] getUserMoveInput(){
//        System.out.print("Enter the row (0-2): ");
//        int row = scanner.nextInt();
//        System.out.print("Enter the column (0-2): ");
//        int col = scanner.nextInt();
        while(true){
            System.out.println("Choose the box number (1-9) which is available and where you want to place your symbol: ");
            int boxNumber = sc.nextInt();

            if(boxNumber>=1 && boxNumber<=9){
                int row = (boxNumber-1)/3;
                int col = (boxNumber-1)%3;
                return new int[]{row,col};
            }
            System.out.println("Invalid box number. Please choose a number between 1 and 9.");
        }
    }
}
