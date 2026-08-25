package com.scaler.model;

import java.util.Scanner;

public class InputAndDisplay {

    // Here we can update this further by taking the box number as the user input
    public int[][] getUserMoveInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your move: row and column number (0-based index): ");
        int x = sc.nextInt();
        int y = sc.nextInt();
        return new int[][]{{x,y}};
    }
}
