package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Peao extends ChessPiece {

    private ChessMatch chessMatch;

    public Peao(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

            // #Special move enPassan
            if(position.getRow() == 3){
                Position left = new Position(position.getRow(), position.getColumn() -1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassanVulnerable()){
                    mat[left.getRow() -1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() +1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassanVulnerable()){
                    mat[right.getRow() -1][right.getColumn()] = true;
                }
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
            // #Special move enPassan
            if(position.getRow() == 4){
                Position left = new Position(position.getRow(), position.getColumn() -1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassanVulnerable()){
                    mat[left.getRow() +1][left.getColumn()] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() +1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassanVulnerable()){
                    mat[right.getRow() +1][right.getColumn()] = true;
                }
            }
        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }

}

