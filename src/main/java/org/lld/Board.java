package org.lld;

public class Board {

    PlayerPiece[][] playerPieces;
    int row;
    int column;

    public Board(int row) {
        this.playerPieces = new PlayerPiece[row][row];
        this.row = row;
        this.column = row;
    }

    public void printBoard(){
        for(int i=0;i<row;i++){
            for(int j=0;j<column ;j++){
                System.out.print(((playerPieces[i][j]==null)? " " : playerPieces[i][j]) + "|");
            }
            System.out.println("\n--------");
        }
    }

    public boolean  playerRoll(int x, int y, Player player){
        if( x>row-1 || y>column-1 || x<0 || y<0|| playerPieces[x][y] != null){
            System.out.println("Enter valid row and column!!");
            printBoard();
            return false;
        }else {
            playerPieces[x][y] = player.playerPiece;
            printBoard();
            return true;
        }
    }
    public boolean isGameWon(){
        //check all the rows
        for(int i=0;i<row;i++){
            boolean isWon =true;
            PlayerPiece p  = playerPieces[i][0];
            for(int j=0;j<column;j++){
                if( p==null || p != playerPieces[i][j]){
                    isWon = false;
                }
            }
            if(isWon){
                return isWon;
            }
        }

        //check all columns
        for(int i=0;i<column;i++){
            boolean isWon = true;
            PlayerPiece p = playerPieces[0][i];
            for(int j=0;j<row;j++){
                if( p==null || p != playerPieces[j][i]){
                    isWon = false;
                }
            }
            if(isWon){
                return isWon;
            }
        }
        //check diagonally
        boolean isWon = true;
        PlayerPiece p = playerPieces[0][0];
        for(int i=1;i<row;i++){
            if( p==null || playerPieces[i][i] != p){
                isWon = false;
            }
        }
        if(isWon){
            return isWon;
        }

        p = playerPieces[0][column-1];
        for(int i=row-2;i>=0;i--){
            if( p==null || playerPieces[row-1-i][i] != p){
                isWon = false;
            }
        }
        if(isWon){
            return isWon;
        }
        return false;
    }
}
