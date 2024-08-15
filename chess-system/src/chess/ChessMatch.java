package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.Rei;
import chess.pieces.Torre;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        this.board = new Board(8, 8);
        initialSetup();
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

    private void initialSetup(){
        board.placePiece(new Torre(board, Color.WHITE), new Position(2,1));
        board.placePiece(new Rei(board, Color.BLACK), new Position(0, 2));
        board.placePiece(new Rei(board, Color.WHITE), new Position(0, 4));



    }
}
