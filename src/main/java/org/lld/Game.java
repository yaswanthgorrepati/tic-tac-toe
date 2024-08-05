package org.lld;

import java.util.Scanner;

public class Game {
    Board board = new Board(3);
    Player player_X = new Player(PlayerPiece.X);
    Player player_O = new Player(PlayerPiece.O);

    public void gameStart(){
        System.out.println("Game Start!!\n");
        board.printBoard();
        int r;
        int c;
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        while(true){
            while(true) {
                System.out.println("player x turn");
                System.out.println("enter row and column number");
                r = myObj.nextInt();
                c = myObj.nextInt();
                if (board.playerRoll(r, c, player_X)) {
                    break;
                }
            }
            if(board.isGameWon()){
                System.out.println("Player X won the game!!");
                break;
            }
            while(true){
                System.out.println("player 0 turn");
                r = myObj.nextInt();
                c = myObj.nextInt();
                if(board.playerRoll(r, c, player_O)){
                    break;
                }
            }
            if(board.isGameWon()){
                System.out.println("Player 0 won the game!!");
                break;
            }
        }
        System.out.println("Game End!!");
    }
}
