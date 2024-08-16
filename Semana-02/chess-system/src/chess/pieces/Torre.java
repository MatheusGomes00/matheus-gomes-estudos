package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Torre extends ChessPiece {
    public Torre(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "T";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position pAux = new Position(0, 0);

        // pra cima
        pAux.setValues(position.getRow() -1, position.getColumn());
        while(getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
            pAux.setRow(pAux.getRow() - 1);
        }
        if(getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }
        // pra esquerda
        pAux.setValues(position.getRow(), position.getColumn() -1);
        while(getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
            pAux.setColumn(pAux.getColumn() - 1);
        }
        if(getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }
        // pra direita
        pAux.setValues(position.getRow(), position.getColumn() +1);
        while(getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
            pAux.setColumn(pAux.getColumn() + 1);
        }
        if(getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }
        // pra baixo
        pAux.setValues(position.getRow() +1, position.getColumn());
        while(getBoard().positionExists(pAux) && !getBoard().thereIsAPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
            pAux.setRow(pAux.getRow() + 1);
        }
        if(getBoard().positionExists(pAux) && isThereOpponentPiece(pAux)){
            mat[pAux.getRow()][pAux.getColumn()] = true;
        }

        return mat;
    }


}
