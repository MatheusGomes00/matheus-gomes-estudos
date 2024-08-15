package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;

public class App {
    public static void main(String[] args) {
        System.out.println("hello world");

        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());


    }
}
