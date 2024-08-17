package chess.pieces;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bispo extends ChessPiece {


    public Bispo(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position pAux = new Position(0, 0);

        // noroeste
        pAux.setValues(position.getRow() -1, position.getColumn() -1);
        while(getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
            pAux.setValues(pAux.getRow() -1, pAux.getColumn() -1);
        }
        if(getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }
        // nordeste
        pAux.setValues(position.getRow() -1, position.getColumn() +1);
        while(getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
            pAux.setValues(pAux.getRow() -1, pAux.getColumn() +1);
        }
        if(getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }
        // sudeste
        pAux.setValues(position.getRow() +1, position.getColumn() +1);
        while(getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
            pAux.setValues(pAux.getRow() +1, pAux.getColumn() +1);
        }
        if(getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }
        // sudoeste
        pAux.setValues(position.getRow() +1, position.getColumn() -1);
        while(getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
            pAux.setValues(pAux.getRow() +1, pAux.getColumn() -1);
        }
        if(getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }

        return mat;
    }
}
