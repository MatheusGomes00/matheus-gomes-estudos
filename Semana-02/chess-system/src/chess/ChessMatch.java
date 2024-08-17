package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.Peao;
import chess.pieces.Rei;
import chess.pieces.Torre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMatch {

    private int turn;
    private Color currentPlayer;
    private Board board;
    private boolean check;
    private boolean checkMate;

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        this.board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.BRANCO;
        initialSetup();
    }

    public int getTurn() {
        return turn;
    }

    public boolean getCheckMate() {
        return checkMate;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean getCheck(){
        return check;
    }

    public ChessPiece[][] getPieces(){
        ChessPiece[][] matrizAux = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i=0; i< board.getRows(); i++){
            for (int j = 0; j< board.getColumns(); j++){
                matrizAux[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return matrizAux;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();

    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);

        if(testCheck(currentPlayer)){
            undoMove(source, target, capturedPiece);
            throw new ChessException("Voce não pose se colocar em Check");
        }

        check = (testCheck(opponent(currentPlayer))) ? true : false;

        if(testCheckMate(opponent(currentPlayer))){
            checkMate = true;
        } else{
            nextTurn();
        }

        return (ChessPiece)capturedPiece;
    }

    private Piece makeMove(Position source, Position target){
        ChessPiece p = (ChessPiece) board.removePiece(source);
        p.increaseMoveCount();
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);

        if(capturedPiece != null){
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        return capturedPiece;
    }

    private void undoMove(Position source, Position target, Piece capturedPiece){
        ChessPiece p = (ChessPiece)board.removePiece(target);
        p.decreaseMoveCount();
        board.placePiece(p, source);

        if(capturedPiece != null){
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoard.add(capturedPiece);
        }
    }

    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("Nao tem nenhuma peça na posicao de origem");
        }
        if(currentPlayer != ((ChessPiece)board.piece(position)).getColor()){
            throw new ChessException("A peca escolhina nao e sua");
        }
        if(!board.piece(position).isThereAnyPossibleMove()){
            throw new ChessException("Nao existe movimentos possiveis para a peca escolhida.");
        }
    }

    private void validateTargetPosition(Position source, Position target){
        if(!board.piece(source).possibleMove(target)){
            throw new ChessException("A peca escolhida nao pode se mover para posicao destino");
        }
    }

    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.BRANCO) ? Color.PRETO : Color.BRANCO;
    }


    private Color opponent(Color color){
        return (color == Color.BRANCO) ? Color.PRETO : Color.BRANCO;
    }

    private ChessPiece king(Color color){
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
        for (Piece p: list){
            if(p instanceof Rei){
                return (ChessPiece)p;
            }
        }
        throw new IllegalStateException("Nao tem rei " + color + " no tabuleiro... bina o adm");
    }

    private boolean testCheck(Color color){
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == opponent(color)).collect(Collectors.toList());
        for(Piece p: opponentPieces){
            boolean[][] mat = p.possibleMoves();
            if(mat[kingPosition.getRow()][kingPosition.getColumn()]){
                return true;
            }
        }
        return false;
    }

    private boolean testCheckMate(Color color){
        if(!testCheck(color)){
            return false;
        }
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());

        for(Piece p: list){
            boolean[][] mat = p.possibleMoves();
            for(int i=0; i< board.getRows(); i++){
                for(int j=0; j< board.getColumns(); j++){
                    if(mat[i][j]){
                        Position source = ((ChessPiece)p).getChessPosition().toPosition();
                        Position target = new Position(i, j);
                        Piece capturedPiece = makeMove(source, target);
                        boolean testCheck = testCheck(color);
                        undoMove(source, target, capturedPiece);
                        if(!testCheck){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
        piecesOnTheBoard.add(piece);

    }

    private void initialSetup(){
        // pecas brancas
        placeNewPiece('a', 1, new Torre(board, Color.BRANCO));
        // placeNewPiece('b', 1, new Cavalo(board, Color.BRANCO));
        // placeNewPiece('c', 1, new Bispo(board, Color.BRANCO));
        // placeNewPiece('d', 1, new Rainha(board, Color.BRANCO));
        placeNewPiece('e', 1, new Rei(board, Color.BRANCO));
        // placeNewPiece('f', 1, new Bispo(board, Color.BRANCO));
        // placeNewPiece('g', 1, new Cavalo(board, Color.BRANCO));
        placeNewPiece('h', 1, new Torre(board, Color.BRANCO));
        placeNewPiece('a', 2, new Peao(board, Color.BRANCO));
        placeNewPiece('b', 2, new Peao(board, Color.BRANCO));
        placeNewPiece('c', 2, new Peao(board, Color.BRANCO));
        placeNewPiece('d', 2, new Peao(board, Color.BRANCO));
        placeNewPiece('e', 2, new Peao(board, Color.BRANCO));
        placeNewPiece('f', 2, new Peao(board, Color.BRANCO));
        placeNewPiece('g', 2, new Peao(board, Color.BRANCO));
        placeNewPiece('h', 2, new Peao(board, Color.BRANCO));

        // pecas pretas
        placeNewPiece('a', 8, new Torre(board, Color.PRETO));
        // placeNewPiece('b', 8, new Cavalo(board, Color.PRETO));
        // placeNewPiece('c', 8, new Bispo(board, Color.PRETO));
        // placeNewPiece('d', 8, new Rainha(board, Color.PRETO));
        placeNewPiece('e', 8, new Rei(board, Color.PRETO));
        // placeNewPiece('f', 8, new Bispo(board, Color.PRETO));
        // placeNewPiece('g', 8, new Cavalo(board, Color.PRETO));
        placeNewPiece('h', 8, new Torre(board, Color.PRETO));
        placeNewPiece('a', 7, new Peao(board, Color.PRETO));
        placeNewPiece('b', 7, new Peao(board, Color.PRETO));
        placeNewPiece('c', 7, new Peao(board, Color.PRETO));
        placeNewPiece('d', 7, new Peao(board, Color.PRETO));
        placeNewPiece('e', 7, new Peao(board, Color.PRETO));
        placeNewPiece('f', 7, new Peao(board, Color.PRETO));
        placeNewPiece('g', 7, new Peao(board, Color.PRETO));
        placeNewPiece('h', 7, new Peao(board, Color.PRETO));
    }
}
