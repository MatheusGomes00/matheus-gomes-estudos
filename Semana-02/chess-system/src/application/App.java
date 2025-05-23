package application;

// import boardgame.Board;
// import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        // para acessar via terminal, de preferencia o bash do git
        // acessar o diretorio do projeto:
        // C:\Projetos\DesafioXadrez\out\production\chess-system
        // e rodar o comando: java application.app

        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        List<ChessPiece> captured = new ArrayList<>();

        while(!chessMatch.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.print("\nOrigem: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.print("\nDestino: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }

                if(chessMatch.getPromoted() != null){
                    System.out.print("Digite a peca para promocao (B/C/T/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    while(!type.equals("B") && !type.equals("C") && !type.equals("T") && !type.equals("Q")){
                        System.out.print("Tipo invalido. Digite a peca para promocao (B/C/T/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    chessMatch.replacePromotedPiece(type);
                }
            } catch(ChessException | InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}
