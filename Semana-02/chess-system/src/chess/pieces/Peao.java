package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Peao extends ChessPiece {



    public Peao(Board board, Color color) {
        super(board, color);

    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position pAux = new Position(0, 0);

        if(getColor() == Color.BRANCO) {
            pAux.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux)) {
                mat[pAux.getRow()][pAux.getColumn()] = true;
            }
            pAux.setValues(position.getRow() - 2, position.getColumn());
            Position pAux2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux) && getBoard().positionExists(pAux2) && !getBoard().thereIsAPiece(pAux2) && getMoveCount() == 0) {
                mat[pAux.getRow()][pAux.getColumn()] = true;
            }
            pAux.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)) {
                mat[pAux.getRow()][pAux.getColumn()] = true;
            }
            pAux.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)) {
                mat[pAux.getRow()][pAux.getColumn()] = true;
            }
        } else {
            pAux.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux)) {
                mat[pAux.getRow()][pAux.getColumn()] = true;
            }
            pAux.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
                mat[pAux.getRow()][pAux.getColumn()] = true;
            }
            pAux.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)) {
                mat[pAux.getRow()][pAux.getColumn()] = true;
            }
            pAux.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)) {
                mat[pAux.getRow()][pAux.getColumn()] = true;
            }

        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }

}

