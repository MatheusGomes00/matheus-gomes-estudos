package chess;

import boardgame.Board;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8) ;
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] matrizAux = new ChessPiece[board.getRows()][board.getColumn()];
        for(int i=0; i< board.getRows(); i++){
            for (int j=0; j< board.getColumn(); j++){
                matrizAux[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return matrizAux;
    }
}
